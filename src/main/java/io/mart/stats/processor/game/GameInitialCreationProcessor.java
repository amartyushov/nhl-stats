package io.mart.stats.processor.game;

import java.util.List;
import java.util.stream.Collectors;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.service.game.GameService;
import org.openapi.model.ScheduleGame;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(1)
@Service
public class GameInitialCreationProcessor implements GameProcessor {
	
	private final GameService gameService;
	
	
	public GameInitialCreationProcessor(GameService gameService) {
		this.gameService = gameService;
	}
	
	
	@Override
	public List<GameDTO> process(List<ScheduleGame> rawGames) {
		List<GameDTO> result = rawGames.stream()
				.filter(this::notExistent)
				.map(this::retrieveGameDto)
				.map(gameService::create)
				.collect(Collectors.toList());
		return result;
	}
	
	
	private boolean notExistent(ScheduleGame rawGame) {
		return gameService.get(rawGame.getGamePk()) == null;
	}
	
	
	private GameDTO retrieveGameDto(ScheduleGame rawGame) {
		GameDTO gameDTO = new GameDTO();
		gameDTO
				.setGameId(rawGame.getGamePk())
				.setDate(rawGame.getGameDate())
				.setHomeScore(rawGame.getTeams().getHome().getScore().intValue())
				.setAwayScore(rawGame.getTeams().getAway().getScore().intValue())
				.setHomeTeamId(rawGame.getTeams().getHome().getTeam().getId().intValue())
				.setAwayTeamId(rawGame.getTeams().getAway().getTeam().getId().intValue());
		return gameDTO;
	}
}
