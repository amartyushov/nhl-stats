package io.mart.stats.converters;

import java.time.ZoneOffset;
import java.util.Optional;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.entities.GameEntity;
import org.springframework.stereotype.Service;

@Service
public class GameConverter implements Converter<GameEntity, GameDTO> {
	
	@Override
	public GameDTO toDto(GameEntity gameEntity) {
		GameDTO dto = new GameDTO();
		Optional.ofNullable(gameEntity.getId()).ifPresent(dto::setId);
		Optional.ofNullable(gameEntity.getDate()).ifPresent(v -> dto.setDate(v.toInstant().atOffset(ZoneOffset.UTC)));
		Optional.ofNullable(gameEntity.getAway()).ifPresent(dto::setAwayScore);
		Optional.ofNullable(gameEntity.getHome()).ifPresent(dto::setHomeScore);
		return dto;
	}
	
	
	@Override
	public GameEntity toEntity(GameDTO gameDTO) {
		throw new RuntimeException("Converter not implemented");
	}
}
