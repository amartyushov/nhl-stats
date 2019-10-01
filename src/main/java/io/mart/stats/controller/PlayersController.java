package io.mart.stats.controller;

import io.mart.stats.entities.enums.Nationality;
import io.mart.stats.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayersController {
	
	
	private PlayersService playersService;
	
	
	@Autowired
	public PlayersController(PlayersService playersService) {
		this.playersService = playersService;
	}
	
	
	@GetMapping("/players")
	public Object getAll() {
		return playersService.getAllPlayers();
	}
	
	
	@GetMapping("/players/{country}")
	public Object betByCountry(@PathVariable Nationality country) {
		return playersService.getPlayersByCountry(country);
	}
	
	
}
