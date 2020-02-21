package io.mart.stats.controller;

import java.util.List;

import io.mart.stats.dto.TeamDTO;
import io.mart.stats.processor.team.TeamProcessors;
import org.openapi.api.TeamsApi;
import org.openapi.invoker.ApiException;
import org.openapi.model.Teams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
	
	private final TeamProcessors processor;
	private TeamsApi teamsApi = new TeamsApi();
	
	
	public TeamController(TeamProcessors processor) {
		this.processor = processor;
	}
	
	
	@GetMapping("/teams")
	public List<TeamDTO> getAll() throws ApiException {
		Teams teams = teamsApi.getTeams(null, null);
		return processor.process(teams.getTeams());
	}
	
}
