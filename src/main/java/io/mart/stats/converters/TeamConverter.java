package io.mart.stats.converters;

import io.mart.stats.exceptions.ConverterException;
import io.mart.stats.model.HockeyTeam;
import io.swagger.client.model.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamConverter implements Converter<Team, HockeyTeam> {
	
	@Override
	public Team toSwagger(HockeyTeam hockeyTeam) {
		throw new ConverterException("Not implemented");
	}
	
	
	@Override
	public HockeyTeam fromSwagger(Team team) {
		return new HockeyTeam()
				.setId(team.getId().intValue())
				.setName(team.getName());
	}
	
}
