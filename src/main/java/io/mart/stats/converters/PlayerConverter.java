package io.mart.stats.converters;

import io.mart.stats.entities.HockeyPlayer;
import io.mart.stats.entities.enums.Nationality;
import io.mart.stats.entities.enums.Position;
import io.swagger.client.model.Player;
import io.swagger.client.model.Roster;
import org.springframework.stereotype.Service;

@Service
public class PlayerConverter {
	
	public HockeyPlayer updateFromPlayer(Player playerProvider, HockeyPlayer playerToUpdate) {
		return playerToUpdate.setId(playerProvider.getId().intValue())
				.setName(playerProvider.getFullName())
				.setPosition(Position.valueOf(playerProvider.getPrimaryPosition().getAbbreviation()))
				.setNationality(Nationality.valueOf(playerProvider.getNationality()));
	}
	
	
	public HockeyPlayer createFromRoster(Roster roster) {
		return new HockeyPlayer().setId(roster.getPerson().getId().intValue())
				.setName(roster.getPerson().getFullName())
				.setPosition(Position.valueOf(roster.getPosition().getCode()));
	}
	
	
}
