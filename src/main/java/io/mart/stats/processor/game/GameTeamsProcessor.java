package io.mart.stats.processor.game;

import java.util.List;
import java.util.stream.Collectors;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.service.game.GameService;
import org.openapi.model.ScheduleGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class GameTeamsProcessor implements GameProcessor {
	
	private final GameService gameService;
	
	
	@Autowired
	public GameTeamsProcessor(GameService gameService) {
		this.gameService = gameService;
	}
	
	
	@Override
	public List<GameDTO> process(List<ScheduleGame> rawGames) {
		return rawGames.stream()
				.map(rawGame -> gameService.updateWithTeams(
						rawGame.getGamePk(),
						rawGame.getTeams().getAway().getTeam().getId().intValue(),
						rawGame.getTeams().getHome().getTeam().getId().intValue()))
				.collect(Collectors.toList());
	}
}
