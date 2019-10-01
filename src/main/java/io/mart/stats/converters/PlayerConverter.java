package io.mart.stats.converters;

import io.mart.stats.model.HockeyPlayer;
import io.mart.stats.model.enums.Nationality;
import io.mart.stats.model.enums.Position;
import io.swagger.client.model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerConverter {
	
	public HockeyPlayer fromRoster(Player player) {
		return new HockeyPlayer().setId(player.getId().intValue())
				.setName(player.getFullName())
				.setPosition(Position.valueOf(player.getPrimaryPosition().getAbbreviation()))
				.setNationality(Nationality.valueOf(player.getNationality()));
	}
}
