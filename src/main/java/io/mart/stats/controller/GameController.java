package io.mart.stats.controller;

import java.util.List;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.processor.game.GameIdProcessor;
import org.openapi.api.ScheduleApi;
import org.openapi.invoker.ApiException;
import org.openapi.model.Schedule;
import org.openapi.model.ScheduleDay;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	private final GameIdProcessor processor;
	ScheduleApi scheduleApi = new ScheduleApi();
	
	
	public GameController(GameIdProcessor processor) {
		this.processor = processor;
	}
	
	
	@GetMapping("/games")
	public List<GameDTO> getAll() throws ApiException {
		Schedule schedule = scheduleApi.getSchedule(null, null, null, null);
		ScheduleDay day = schedule.getDates().iterator().next();
		List<GameDTO> result = processor.process(day.getGames());
		return result;
	}
	
}
