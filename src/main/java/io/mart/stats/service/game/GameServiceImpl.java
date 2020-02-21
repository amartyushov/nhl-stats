package io.mart.stats.service.game;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

import io.mart.stats.converters.GameConverter;
import io.mart.stats.dto.GameDTO;
import io.mart.stats.entities.GameEntity;
import io.mart.stats.entities.TeamEntity;
import io.mart.stats.exceptions.ConverterException;
import io.mart.stats.repository.GameRepository;
import io.mart.stats.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
	
	private final GameRepository gameRepository;
	private final GameConverter gameConverter;
	private final TeamRepository teamRepository;
	
	
	@Autowired
	public GameServiceImpl(
			GameRepository gameRepository,
			GameConverter gameConverter,
			TeamRepository teamRepository) {
		this.gameRepository = gameRepository;
		this.gameConverter = gameConverter;
		this.teamRepository = teamRepository;
	}
	
	
	@Override
	public GameDTO createWithId(BigDecimal id) {
		GameEntity gameEntity = new GameEntity();
		gameEntity.setGameId(id);
		GameEntity savedEntity = gameRepository.save(gameEntity);
		return gameConverter.toDto(savedEntity);
	}
	
	
	@Override
	public GameDTO updateWithDate(BigDecimal id, OffsetDateTime date) {
		Optional<GameEntity> gameEntity = Optional.ofNullable(gameRepository
				.findByGameId(id)
				.map(entity -> entity.setDate(Date.from(date.toInstant())))
				.orElseThrow(throwNotFound(id)));
		
		gameEntity.ifPresent(gameRepository::save);
		return gameConverter.toDto(gameEntity.orElseThrow(throwNotFound(id)));
	}
	
	
	@Override
	public GameDTO updateWithScore(BigDecimal id, Integer away, Integer home) {
		Optional<GameEntity> gameEntity = Optional.ofNullable(gameRepository.findByGameId(id)
				.map(game -> game.setAwayScore(away))
				.map(g -> g.setHomeScore(home))
				.orElseThrow(throwNotFound(id)));
		
		gameEntity.ifPresent(gameRepository::save);
		return gameConverter.toDto(gameEntity.orElseThrow(throwNotFound(id)));
	}
	
	
	@Override
	public GameDTO updateWithTeams(BigDecimal id, Integer awayTeamId, Integer homeTeamId) {
		Optional<TeamEntity> awayTeam = teamRepository.findByTeamId(awayTeamId);
		Optional<TeamEntity> homeTeam = teamRepository.findByTeamId(homeTeamId);
		
		Optional<GameEntity> gameEntity = Optional.ofNullable(gameRepository.findByGameId(id)
				.map(game -> game.setAwayTeam(awayTeam.orElse(null)))
				.map(g -> g.setHomeTeam(homeTeam.orElse(null)))
				.orElseThrow(throwNotFound(id)));
		gameEntity.ifPresent(gameRepository::save);
		return gameConverter.toDto(gameEntity.orElseThrow(throwNotFound(id)));
	}
	
	
	private Supplier<ConverterException> throwNotFound(BigDecimal id) {
		return () -> new ConverterException("No game found with id " + id);
	}
}
