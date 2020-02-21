package io.mart.stats.processor.game;

import java.util.List;
import java.util.stream.Collectors;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.service.game.GameService;
import org.openapi.model.ScheduleGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class GameIdProcessor implements GameProcessor {
	
	
	private final GameService gameService;
	
	
	@Autowired
	public GameIdProcessor(GameService gameService) {
		this.gameService = gameService;
	}
	
	
	@Override
	public List<GameDTO> process(List<ScheduleGame> rawGames) {
		return rawGames.stream()
				.map(rawGame -> gameService.createWithId(rawGame.getGamePk()))
				.collect(Collectors.toList());
	}
}
