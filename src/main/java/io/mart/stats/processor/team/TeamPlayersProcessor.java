package io.mart.stats.processor.team;

import java.util.List;

import io.mart.stats.dto.TeamDTO;
import io.mart.stats.service.player.PlayerService;
import io.mart.stats.service.team.TeamService;
import org.openapi.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamPlayersProcessor implements TeamProcessor {
	
	@Autowired
	public TeamPlayersProcessor(
			TeamService service,
			PlayerService playerService) {
	}
	
	
	@Override
	public List<TeamDTO> process(List<Team> rawTeams) {
		
		return null;
	}
}
