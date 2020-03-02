package io.mart.stats.converters;

import java.util.Optional;

import io.mart.stats.dto.TeamDTO;
import io.mart.stats.entities.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter implements Converter<TeamEntity, TeamDTO> {
	
	@Override
	public TeamDTO toDto(TeamEntity entity) {
		TeamDTO dto = new TeamDTO();
		Optional.ofNullable(entity.getTeamId()).ifPresent(dto::setId);
		Optional.ofNullable(entity.getName()).ifPresent(dto::setName);
		return dto;
	}
	
	
	@Override
	public TeamEntity toEntity(TeamDTO teamDTO) {
		TeamEntity entity = new TeamEntity();
		entity
				.setTeamId(teamDTO.getId())
				.setName(teamDTO.getName());
		return entity;
	}
}
