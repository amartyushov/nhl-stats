package io.mart.stats.processor.team;

import java.util.ArrayList;
import java.util.List;

import io.mart.stats.dto.TeamDTO;
import org.openapi.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamProcessors {
	
	private final List<TeamProcessor> teamProcessors;
	
	
	@Autowired
	public TeamProcessors(List<TeamProcessor> teamProcessors) {
		this.teamProcessors = teamProcessors;
	}
	
	
	public List<TeamDTO> process(List<Team> rawTeams) {
		List<TeamDTO> result = new ArrayList<>();
		for (TeamProcessor processor : teamProcessors) {
			result = processor.process(rawTeams);
		}
		return result;
	}
	
}
