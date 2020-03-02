package io.mart.stats.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.processor.game.GameProcessors;
import io.mart.stats.service.game.GameService;
import lombok.extern.slf4j.Slf4j;
import org.openapi.api.ScheduleApi;
import org.openapi.invoker.ApiException;
import org.openapi.model.Schedule;
import org.openapi.model.ScheduleDay;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GameController {
	
	private final GameProcessors gameProcessors;
	private final GameService gameService;
	ScheduleApi scheduleApi = new ScheduleApi();
	
	
	public GameController(
			GameProcessors gameProcessors,
			GameService gameService) {
		this.gameProcessors = gameProcessors;
		this.gameService = gameService;
	}
	
	
	@GetMapping("/populate/games")
	public List<GameDTO> populateGames() throws ApiException {
		Instant start = Instant.now();
		List<GameDTO> gameDTOS = populateForMeasure();
		Instant end = Instant.now();
		log.info("Games population took {}", Duration.between(start, end).toMillis());
		return gameDTOS;
	}
	
	
	private List<GameDTO> populateForMeasure() throws ApiException {
		Schedule schedule = scheduleApi.getSchedule(null, null, null, null);
		ScheduleDay day = schedule.getDates().iterator().next();
		return gameProcessors.process(day.getGames());
	}
	
	
	@GetMapping("/games")
	public List<GameDTO> getGames() {
		Instant start = Instant.now();
		List<GameDTO> allGames = gameService.getAll();
		Instant end = Instant.now();
		log.info("Getting of all games took {}", Duration.between(start, end).toMillis());
		return allGames;
	}
	
}
