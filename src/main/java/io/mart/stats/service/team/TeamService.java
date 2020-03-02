package io.mart.stats.service.team;

import java.math.BigDecimal;
import java.util.List;

import io.mart.stats.dto.TeamDTO;

public interface TeamService {
	
	TeamDTO createWithIdAndName(BigDecimal id, String name);
	
	List<TeamDTO> getTeams();
	
}
