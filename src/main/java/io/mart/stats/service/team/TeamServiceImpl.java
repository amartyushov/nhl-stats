package io.mart.stats.service.team;

import java.math.BigDecimal;

import io.mart.stats.converters.TeamConverter;
import io.mart.stats.dto.TeamDTO;
import io.mart.stats.entities.TeamEntity;
import io.mart.stats.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
	
	private final TeamRepository repository;
	private final TeamConverter converter;
	
	
	@Autowired
	public TeamServiceImpl(TeamRepository repository, TeamConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}
	
	
	@Override
	public TeamDTO createWithIdAndName(BigDecimal id, String name) {
		TeamEntity entity = new TeamEntity();
		entity
				.setTeamId(id.intValue())
				.setName(name);
		TeamEntity savedEntity = repository.save(entity);
		return converter.toDto(savedEntity);
	}
}
