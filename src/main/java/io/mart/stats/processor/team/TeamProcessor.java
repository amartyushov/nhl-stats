package io.mart.stats.processor.team;

import java.util.List;

import io.mart.stats.dto.TeamDTO;
import io.mart.stats.processor.Processor;
import org.openapi.model.Team;
import org.springframework.stereotype.Component;

@Component
public interface TeamProcessor extends Processor {
	
	List<TeamDTO> process(List<Team> rawTeams);
	
}
