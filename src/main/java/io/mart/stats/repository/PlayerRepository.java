package io.mart.stats.repository;

import java.util.List;

import io.mart.stats.entities.HockeyPlayer;
import io.mart.stats.entities.enums.Nationality;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<HockeyPlayer, Integer> {
	
	List<HockeyPlayer> findAllByNationality(Nationality nationality);
}
