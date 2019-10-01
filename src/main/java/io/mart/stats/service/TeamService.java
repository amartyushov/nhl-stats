package io.mart.stats.service;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.mart.stats.converters.TeamConverter;
import io.mart.stats.entities.HockeyTeam;
import io.mart.stats.repository.TeamRepository;
import io.swagger.client.ApiException;
import io.swagger.client.api.TeamsApi;
import io.swagger.client.model.Teams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
	
	private TeamConverter teamConverter;
	private TeamRepository teamRepository;
	private TeamsApi teamsApi = new TeamsApi();
	private List<HockeyTeam> teams = new ArrayList<>();
	
	
	@Autowired
	public TeamService(
			TeamConverter teamConverter,
			TeamRepository teamRepository
	) {
		this.teamConverter = teamConverter;
		this.teamRepository = teamRepository;
	}
	
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	
	public List<HockeyTeam> getTeams() {
		LOG.info("Getting team ids");
		if (teams == null || teams.isEmpty()) {
			teams = getTeamsInternal(null);
			teams.forEach(teamRepository::save);
		}
		return teams;
	}
	
	
	private List<HockeyTeam> getTeamsInternal(String expand) {
		BigDecimal season = null;
		
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
