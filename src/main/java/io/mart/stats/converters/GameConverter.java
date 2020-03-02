package io.mart.stats.converters;

import java.time.ZoneOffset;
import java.util.Date;
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
		
		Optional.ofNullable(gameEntity.getAwayTeam()).ifPresent(awayTeam -> dto.setAwayTeamId(awayTeam.getTeamId()));
		Optional.ofNullable(gameEntity.getHomeTeam()).ifPresent(homeTeam -> dto.setHomeTeamId(homeTeam.getTeamId()));
		return dto;
	}
	
	
	/**
	 * Teams are not converted here, because it requires repository look up
	 *
	 * @param gameDTO
	 * @return
	 */
	@Override
	public GameEntity toEntity(GameDTO gameDTO) {
		GameEntity entity = new GameEntity();
		Optional.ofNullable(gameDTO.getGameId()).ifPresent(entity::setGameId);
		Optional.ofNullable(gameDTO.getDate()).ifPresent(d -> {
			long milis = d.toInstant().toEpochMilli();
			entity.setDate(new Date(milis));
		});
		
		Optional.ofNullable(gameDTO.getScore().getAway()).ifPresent(entity::setAwayScore);
		Optional.ofNullable(gameDTO.getScore().getHome()).ifPresent(entity::setHomeScore);
		return entity;
	}
}
