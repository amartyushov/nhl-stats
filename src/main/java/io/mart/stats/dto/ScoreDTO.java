package io.mart.stats.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ScoreDTO {
	
	private Integer home;
	private Integer away;
}
