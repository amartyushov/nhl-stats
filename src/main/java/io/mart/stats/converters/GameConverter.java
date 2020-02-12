package io.mart.stats.converters;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.entities.GameEntity;
import org.springframework.stereotype.Service;

@Service
public class GameConverter implements Converter<GameEntity, GameDTO> {
	
	@Override
	public GameDTO toDto(GameEntity gameEntity) {
		GameDTO dto = new GameDTO();
		dto.setId(gameEntity.getId());
		return dto;
	}
	
	
	@Override
	public GameEntity toEntity(GameDTO gameDTO) {
		throw new RuntimeException("Converter not implemented");
	}
}
