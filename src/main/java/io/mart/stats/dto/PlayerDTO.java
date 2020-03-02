package io.mart.stats.dto;


import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.mart.stats.entities.enums.Position;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerDTO {
	
	private BigDecimal playerId;
	private String fullName;
	private Integer jerseyNumber;
	private Position position;
	private TeamDTO team;
}
