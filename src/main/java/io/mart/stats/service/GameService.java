package io.mart.stats.service;

import java.math.BigDecimal;

import io.mart.stats.dto.GameDTO;

public interface GameService {
	
	GameDTO createWithId(BigDecimal id);
	
}
