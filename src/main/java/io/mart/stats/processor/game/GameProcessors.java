package io.mart.stats.processor.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class GameProcessors {
	
	private final List<GameProcessor> gameProcessors;
	
	
	@Autowired
	public GameProcessors(List<GameProcessor> gameProcessors) {
		this.gameProcessors = gameProcessors;
	}
	
}
