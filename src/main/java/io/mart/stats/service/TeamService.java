package io.mart.stats.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import io.mart.stats.converters.TeamConverter;
import io.mart.stats.model.HockeyTeam;
import io.swagger.client.ApiException;
import io.swagger.client.api.TeamsApi;
import io.swagger.client.model.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
	
	private TeamConverter teamConverter;
	private TeamsApi teamsApi = new TeamsApi();
	
	
	@Autowired
	public TeamService(TeamConverter teamConverter) {
		this.teamConverter = teamConverter;
	}
	
	
	public List<HockeyTeam> getTeams() {
		BigDecimal season = null;
		String expand = null;
		
		try {
			Teams swaggerTeams = teamsApi.getTeams(expand, season);
			return swaggerTeams
					.getTeams().stream()
					.map(swaggerTeam -> teamConverter.fromSwagger(swaggerTeam))
					.collect(Collectors.toList());
		} catch (ApiException e) {
			throw new RuntimeException(e);
		}
	}
}
