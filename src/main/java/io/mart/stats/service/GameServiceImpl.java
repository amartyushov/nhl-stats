package io.mart.stats.service;

import java.math.BigDecimal;

import io.mart.stats.converters.GameConverter;
import io.mart.stats.dto.GameDTO;
import io.mart.stats.entities.GameEntity;
import io.mart.stats.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
	
	private final GameRepository gameRepository;
	private final GameConverter gameConverter;
	
	
	@Autowired
	public GameServiceImpl(GameRepository gameRepository, GameConverter gameConverter) {
		this.gameRepository = gameRepository;
		this.gameConverter = gameConverter;
	}
	
	
	@Override
	public GameDTO createWithId(BigDecimal id) {
		GameEntity gameEntity = new GameEntity();
		gameEntity.setId(id);
		GameEntity savedEntity = gameRepository.save(gameEntity);
		return gameConverter.toDto(savedEntity);
	}
}
