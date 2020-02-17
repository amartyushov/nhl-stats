package io.mart.stats.processor.game;

import java.util.List;
import java.util.stream.Collectors;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.service.GameService;
import org.openapi.model.ScheduleGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class GameScoreProcessor implements GameProcessor {
	
	private final GameService gameService;
	
	
	@Autowired
	public GameScoreProcessor(GameService gameService) {
		this.gameService = gameService;
	}
	
	
	@Override
	public List<GameDTO> process(List<ScheduleGame> rawGames) {
		return rawGames.stream()
				.map(game -> gameService.updateWithScore(
						game.getGamePk(),
						game.getTeams().getAway().getScore().intValue(),
						game.getTeams().getHome().getScore().intValue()
				))
				.collect(Collectors.toList());
	}
	
}
