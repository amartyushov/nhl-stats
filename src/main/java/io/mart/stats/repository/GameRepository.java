package io.mart.stats.repository;

import java.math.BigDecimal;
import java.util.Optional;

import io.mart.stats.entities.GameEntity;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, Long> {
	
	Optional<GameEntity> findByGameId(BigDecimal gameId);
}
