package io.mart.stats.processor.game;

import java.util.ArrayList;
import java.util.List;

import io.mart.stats.dto.GameDTO;
import org.openapi.model.Schedule;
import org.openapi.model.ScheduleDay;
import org.openapi.model.ScheduleGame;

public class ScheduleProcessor {
	
	public List<GameDTO> process(Schedule schedule) {
		List<GameDTO> gamesDtos = new ArrayList<>();
		ScheduleDay day = schedule.getDates().iterator().next();
		
		List<ScheduleGame> games = day.getGames();
		games.stream().forEach(game -> {
			GameDTO gameDTO = new GameDTO().setGameId(game.getGamePk());
			gamesDtos.add(gameDTO);
		});
		return gamesDtos;
	}
}
