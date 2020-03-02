package io.mart.stats.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.service.team.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.openapi.api.PlayersApi;
import org.openapi.api.TeamsApi;
import org.openapi.invoker.ApiException;
import org.openapi.model.Teams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PlayerController {
	
	private final TeamService teamService;
	private PlayersApi playersApi = new PlayersApi();
	private TeamsApi teamsApi = new TeamsApi();
	
	
	public PlayerController(
			TeamService teamService) {
		this.teamService = teamService;
	}
	
	
	@GetMapping("/populate/players")
	public List<GameDTO> populatePlayersByTeam() throws ApiException {
		Instant start = Instant.now();
		List<GameDTO> gameDTOS = populateMeasured();
		Instant end = Instant.now();
		log.info("Players by team population took {}", Duration.between(start, end).toMillis());
		return gameDTOS;
	}
	
	
	private List<GameDTO> populateMeasured() throws ApiException {
		Teams teams = teamsApi.getTeams("team.roster", null);
		return null;
	}
	
	
}
