package io.mart.stats.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(Include.NON_NULL)
public class GameDTO {
	
	private BigDecimal gameId;
	private TeamDTO homeTeam = new TeamDTO();
	private TeamDTO awayTeam = new TeamDTO();
	private ScoreDTO score = new ScoreDTO();
	private OffsetDateTime date;
	
	
	public void setAwayScore(Integer away) {
		score.setAway(away);
	}
	
	
	public void setHomeScore(Integer home) {
		score.setHome(home);
	}
	
	
	public void setAwayTeamId(Integer id) {
		awayTeam.setId(id);
	}
	
	
	public void setHomeTeamId(Integer id) {
		homeTeam.setId(id);
	}
	
}
