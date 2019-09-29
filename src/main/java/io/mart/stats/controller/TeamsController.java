package io.mart.stats.controller;

import io.mart.stats.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamsController {
	
	private TeamService teamService;
	
	
	@Autowired
	public TeamsController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	
	@GetMapping("/teams")
	public Object get() {
		return teamService.getTeams();
	}
}
