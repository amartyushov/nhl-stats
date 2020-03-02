package io.mart.stats.repository;

import io.mart.stats.entities.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
	
}
