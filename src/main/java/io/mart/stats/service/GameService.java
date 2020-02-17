package io.mart.stats.service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import io.mart.stats.dto.GameDTO;

public interface GameService {
	
	GameDTO createWithId(BigDecimal id);
	
	GameDTO updateWithDate(BigDecimal id, OffsetDateTime date);
	
}
