package io.mart.stats.service;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.mart.stats.converters.PlayerConverter;
import io.mart.stats.entities.HockeyPlayer;
import io.mart.stats.entities.enums.Nationality;
import io.mart.stats.entities.enums.Seasons;
import io.mart.stats.repository.PlayerRepository;
import io.swagger.client.ApiException;
import io.swagger.client.api.PlayersApi;
import io.swagger.client.api.TeamsApi;
import io.swagger.client.model.Player;
import io.swagger.client.model.Roster;
import io.swagger.client.model.Rosters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayersService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private TeamsApi teamsApi = new TeamsApi();
	private PlayersApi playersApi = new PlayersApi();
	private TeamService teamService;
	private Map<Integer, HockeyPlayer> playerMap = new HashMap<>();
	private PlayerConverter playerConverter;
	private PlayerRepository playerRepository;
	
	
	@Autowired
	public PlayersService(
			TeamService teamService,
			PlayerConverter converter,
			PlayerRepository playerRepository
	) {
		this.teamService = teamService;
		this.playerConverter = converter;
		this.playerRepository = playerRepository;
	}
	
	
	public Collection<HockeyPlayer> getAllPlayers() {
		if (playerMap.isEmpty()) {
			teamService.getTeams().forEach(team -> populatePlayerIds(team.getId()));
			playerMap.keySet().forEach(this::createFinalizedPlayer);
			playerRepository.saveAll(playerMap.values());
		}
		return playerMap.values();
	}
	
	
	private void createFinalizedPlayer(Integer playerId) {
		try {
			List<Player> players = playersApi.getPlayer(BigDecimal.valueOf(playerId)).getTeams();
			players.forEach(player -> playerConverter.updateFromPlayer(player, playerMap.get(playerId)));
		} catch (ApiException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	private void populatePlayerIds(Integer teamId) {
		try {
			Rosters teamRoster = teamsApi.getTeamRoster(
					BigDecimal.valueOf(teamId),
					Seasons.CURRENT.get());
			
			List<Roster> rosters = teamRoster.getTeams();
			rosters.forEach(roster -> {
				HockeyPlayer player = playerConverter.createFromRoster(roster);
				playerMap.put(player.getId(), player);
			});
		} catch (ApiException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<HockeyPlayer> getPlayersByCountry(Nationality country) {
		return playerRepository.findAllByNationality(country);
	}
}
