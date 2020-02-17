package io.mart.stats.processor.game;

import java.util.ArrayList;
import java.util.List;

import io.mart.stats.dto.GameDTO;
import org.openapi.model.ScheduleGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameProcessors {
	
	private final List<GameProcessor> gameProcessors;
	
	
	@Autowired
	public GameProcessors(List<GameProcessor> gameProcessors) {
		this.gameProcessors = gameProcessors;
	}
	
	
	public List<GameDTO> process(List<ScheduleGame> rawGames) {
		List<GameDTO> result = new ArrayList<>();
		for (GameProcessor processor : gameProcessors) {
			result = processor.process(rawGames);
		}
		return result;
	}
	
}
