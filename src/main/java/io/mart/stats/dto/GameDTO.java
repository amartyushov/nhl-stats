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
	
	private BigDecimal id;
	private TeamDTO homeTeam;
	private TeamDTO awayTeam;
	private ScoreDTO core;
	private OffsetDateTime date;
	
}
