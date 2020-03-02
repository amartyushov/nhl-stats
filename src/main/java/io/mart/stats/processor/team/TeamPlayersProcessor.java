package io.mart.stats.processor.team;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.mart.stats.dto.PlayerDTO;
import io.mart.stats.dto.TeamDTO;
import io.mart.stats.entities.enums.Position;
import io.mart.stats.service.player.PlayerService;
import io.mart.stats.service.team.TeamService;
import org.openapi.model.Roster;
import org.openapi.model.Team;
import org.openapi.model.TeamRoster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(2)
@Service
public class TeamPlayersProcessor implements TeamProcessor {
	
	private final PlayerService playerService;
	private final TeamService teamService;
	
	
	@Autowired
	public TeamPlayersProcessor(
			PlayerService playerService,
			TeamService teamService) {
		this.playerService = playerService;
		this.teamService = teamService;
	}
	
	
	@Override
	public List<TeamDTO> process(List<Team> rawTeams) {
		for (Team rawTeam : rawTeams) {
			TeamRoster roster = rawTeam.getRoster();
			
			if (roster == null) {
				throw new RuntimeException("Roster not found for the team " + rawTeam.getId());
			}
			
			List<PlayerDTO> list = roster.getRoster().stream()
					.map(player -> asPlayerDto(player, rawTeam.getId()))
					.map(playerService::create)
					.collect(Collectors.toList());
		}
		return null;
	}
	
	
	private PlayerDTO asPlayerDto(Roster player, BigDecimal teamId) {
		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setPlayerId(player.getPerson().getId());
		playerDTO.setFullName(player.getPerson().getFullName());
		playerDTO.setPosition(Position.valueOf(player.getPosition().getAbbreviation()));
		playerDTO.setJerseyNumber(player.getJerseyNumber().intValue());
		
		Optional<TeamDTO> teamToAdd = teamService.getTeams().stream()
				.filter(teamDTO -> teamDTO.getId().equals(teamId.intValue()))
				.findFirst();
		
		teamToAdd.ifPresent(playerDTO::setTeam);
		
		return playerDTO;
	}
}
