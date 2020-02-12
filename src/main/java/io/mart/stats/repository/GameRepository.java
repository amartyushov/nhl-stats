package io.mart.stats.repository;

import java.math.BigDecimal;

import io.mart.stats.entities.GameEntity;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, BigDecimal> {
	
}
