package io.mart.stats.repository;

import io.mart.stats.entities.HockeyPlayer;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<HockeyPlayer, Integer> {
	
}
