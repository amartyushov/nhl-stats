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
		Optional.ofNullable(gameEntity.getGameId()).ifPresent(dto::setGameId);
		Optional.ofNullable(gameEntity.getDate()).ifPresent(v -> dto.setDate(v.toInstant().atOffset(ZoneOffset.UTC)));
		Optional.ofNullable(gameEntity.getAwayScore()).ifPresent(dto::setAwayScore);
		Optional.ofNullable(gameEntity.getHomeScore()).ifPresent(dto::setHomeScore);
		
		Optional.ofNullable(gameEntity.getAwayTeam()).ifPresent(awayTeam -> dto.setAwayTeamId(awayTeam.getId()));
		Optional.ofNullable(gameEntity.getHomeTeam()).ifPresent(homeTeam -> dto.setHomeTeamId(homeTeam.getId()));
		return dto;
	}
	
	
	@Override
	public GameEntity toEntity(GameDTO gameDTO) {
		throw new RuntimeException("Converter not implemented");
	}
}
