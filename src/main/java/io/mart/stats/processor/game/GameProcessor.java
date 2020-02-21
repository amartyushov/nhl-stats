package io.mart.stats.processor.game;

import java.util.List;

import io.mart.stats.dto.GameDTO;
import io.mart.stats.processor.Processor;
import org.openapi.model.ScheduleGame;
import org.springframework.stereotype.Component;

@Component
public interface GameProcessor extends Processor {
	
	List<GameDTO> process(List<ScheduleGame> rawGames);
	
}
