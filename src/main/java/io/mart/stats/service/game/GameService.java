package io.mart.stats.service.game;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import io.mart.stats.dto.GameDTO;

public interface GameService {
	
	GameDTO create(GameDTO game);
	
	GameDTO get(BigDecimal gameId);
	
	List<GameDTO> getAll();
	
	GameDTO createWithId(BigDecimal id);
	
	GameDTO updateWithDate(BigDecimal id, OffsetDateTime date);
	
	GameDTO updateWithScore(BigDecimal id, Integer away, Integer home);
	
	GameDTO updateWithTeams(BigDecimal id, Integer awayTeamId, Integer homeTeamId);
}
