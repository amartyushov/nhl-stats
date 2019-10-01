package io.mart.stats.repository;

import io.mart.stats.entities.HockeyTeam;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<HockeyTeam, Integer> {
	
}
