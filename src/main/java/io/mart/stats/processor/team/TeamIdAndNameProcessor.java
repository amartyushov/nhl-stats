package io.mart.stats.processor.team;

import java.util.List;
import java.util.stream.Collectors;

import io.mart.stats.dto.TeamDTO;
import io.mart.stats.service.team.TeamService;
import org.openapi.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamIdAndNameProcessor implements TeamProcessor {
	
	private final TeamService service;
	
	
	@Autowired
	public TeamIdAndNameProcessor(TeamService service) {
		this.service = service;
	}
	
	
	@Override
	public List<TeamDTO> process(List<Team> rawTeams) {
		return rawTeams.stream()
				.map(team -> service.createWithIdAndName(team.getId(), team.getName()))
				.collect(Collectors.toList());
	}
}
