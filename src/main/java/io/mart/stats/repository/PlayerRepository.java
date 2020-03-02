package io.mart.stats.repository;

import java.math.BigDecimal;
import java.util.Optional;

import io.mart.stats.entities.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
	
	Optional<PlayerEntity> findByPlayerId(BigDecimal playerId);
}
