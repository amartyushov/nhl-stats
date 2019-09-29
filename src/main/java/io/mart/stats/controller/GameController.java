package io.mart.stats.controller;

import io.swagger.client.ApiException;
import io.swagger.client.api.GamesApi;
import io.swagger.client.api.ScheduleApi;
import io.swagger.client.model.Schedule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	GamesApi gamesApi = new GamesApi();
	ScheduleApi scheduleApi = new ScheduleApi();

	@GetMapping("/games")
	public @ResponseBody Object games() throws ApiException {
		Schedule schedule = scheduleApi.getSchedule(null, null, null, null);
		return schedule.getDates().get(0).getGames().get(0).getContent();
	}

	
}
