package io.mart.stats.repository;

import java.util.Optional;

import io.mart.stats.entities.TeamEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<TeamEntity, Long> {
	
	Optional<TeamEntity> findByTeamId(Integer teamdId);
}
