package io.mart.stats.converters;

import io.mart.stats.entities.HockeyTeam;
import io.swagger.client.model.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamConverter {
	
	public HockeyTeam fromSwagger(Team team) {
		return new HockeyTeam()
				.setId(team.getId().intValue())
				.setName(team.getName());
	}
	
}
