package io.mart.stats.service.game;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import io.mart.stats.converters.GameConverter;
import io.mart.stats.dto.GameDTO;
import io.mart.stats.entities.GameEntity;
import io.mart.stats.entities.TeamEntity;
import io.mart.stats.exceptions.ConverterException;
import io.mart.stats.repository.GameRepository;
import io.mart.stats.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
	public List<GameDTO> getAll() {
		Iterable<GameEntity> gameEntities = gameRepository.findAll();
		return StreamSupport.stream(gameEntities.spliterator(), false)
				.map(gameConverter::toDto)
				.collect(Collectors.toList());
	}
	
	
	@Override
	public GameDTO createWithId(BigDecimal id) {
		log.info("GET GameEntity by game id {}", id);
		Optional<GameEntity> gameEntity = gameRepository.findByGameId(id);
		
		if (gameEntity.isPresent()) {
			log.info("GameEntity for id {} is present => do not create new", id);
			return gameConverter.toDto(gameEntity.get());
		}
		
		GameEntity freshEntity = new GameEntity();
		freshEntity.setGameId(id);
		log.info("SAVE new GameEntity with id {}", id);
		GameEntity savedEntity = gameRepository.save(freshEntity);
		return gameConverter.toDto(savedEntity);
	}
	
	
	@Override
	public GameDTO updateWithDate(BigDecimal id, OffsetDateTime date) {
		Optional<GameEntity> gameEntity = Optional.ofNullable(gameRepository
				.findByGameId(id)
				.map(entity -> entity.setDate(Date.from(date.toInstant())))
				.orElseThrow(throwNotFound(id)));
		
		log.info("SAVE updated GameEntity with date {}", date);
		gameEntity.ifPresent(gameRepository::save);
		return gameConverter.toDto(gameEntity.orElseThrow(throwNotFound(id)));
	}
	
	
	@Override
	public GameDTO updateWithScore(BigDecimal id, Integer away, Integer home) {
		Optional<GameEntity> gameEntity = Optional.ofNullable(gameRepository.findByGameId(id)
				.map(game -> game.setAwayScore(away))
				.map(g -> g.setHomeScore(home))
				.orElseThrow(throwNotFound(id)));
		
		log.info("SAVE updated GameEntity with away score {} and home score {}", away, home);
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
		
		log.info("SAVE updated GameEntity with away team id {} and home team id {}", awayTeamId, homeTeamId);
		gameEntity.ifPresent(gameRepository::save);
		return gameConverter.toDto(gameEntity.orElseThrow(throwNotFound(id)));
	}
	
	
	private Supplier<ConverterException> throwNotFound(BigDecimal id) {
		return () -> new ConverterException("No game found with id " + id);
	}
}
