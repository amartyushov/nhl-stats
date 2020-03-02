package io.mart.stats.converters;

import java.util.Set;

import io.mart.stats.dto.PlayerDTO;
import io.mart.stats.dto.TeamDTO;
import io.mart.stats.entities.PlayerEntity;
import io.mart.stats.entities.TeamEntity;
import io.mart.stats.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter implements Converter<PlayerEntity, PlayerDTO> {
	
	private final TeamRepository teamRepository;
	private final TeamConverter teamConverter;
	
	
	public PlayerConverter(
			TeamRepository teamRepository,
			TeamConverter teamConverter) {
		this.teamRepository = teamRepository;
		this.teamConverter = teamConverter;
	}
	
	
	@Override
	public PlayerDTO toDto(PlayerEntity playerEntity) {
		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO
				.setPlayerId(playerEntity.getPlayerId())
				.setFullName(playerEntity.getFullName())
				.setJerseyNumber(playerEntity.getJerseyNumber())
				.setPosition(playerEntity.getPosition());
		
		Set<TeamEntity> teams = playerEntity.getTeams();
		if (teams.size() == 1) {
			TeamEntity teamEntity = teams.stream().findFirst().get();
			TeamDTO teamDTO = teamConverter.toDto(teamEntity);
			playerDTO.setTeam(teamDTO);
		}
		
		return playerDTO;
	}
	
	
	@Override
	public PlayerEntity toEntity(PlayerDTO playerDTO) {
		PlayerEntity playerEntity = new PlayerEntity();
		playerEntity
				.setPlayerId(playerDTO.getPlayerId())
				.setFullName(playerDTO.getFullName())
				.setJerseyNumber(playerDTO.getJerseyNumber())
				.setPosition(playerDTO.getPosition());
		
		TeamEntity teamEntity = teamConverter.toEntity(playerDTO.getTeam());
		playerEntity.setTeam(teamEntity);
		return playerEntity;
	}
}
