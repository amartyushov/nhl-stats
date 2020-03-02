package io.mart.stats.service.team;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
	
	
	@Override
	public List<TeamDTO> getTeams() {
		Iterable<TeamEntity> allTeams = repository.findAll();
		return StreamSupport.stream(allTeams.spliterator(), false)
				.map(converter::toDto)
				.collect(Collectors.toList());
	}
}
