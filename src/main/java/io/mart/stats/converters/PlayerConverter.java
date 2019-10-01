package io.mart.stats.converters;

import io.mart.stats.exceptions.ConverterException;
import io.mart.stats.model.HockeyPlayer;
import io.mart.stats.model.enums.Nationality;
import io.mart.stats.model.enums.Position;
import io.swagger.client.model.Player;

public class PlayerConverter implements Converter<Player, HockeyPlayer.HockeyPlayerBuilder> {
	
	@Override
	public Player toSwagger(HockeyPlayer.HockeyPlayerBuilder hockeyPlayerBuilder) {
		throw new ConverterException("Not impl");
	}
	
	
	@Override
	public HockeyPlayer.HockeyPlayerBuilder fromSwagger(Player player) {
		return HockeyPlayer.HockeyPlayerBuilder
				.newInstance()
				.id(player.getId().intValue())
				.name(player.getFullName())
				.nationality(Nationality.valueOf(player.getNationality()))
				.position(Position.valueOf(player.getPrimaryPosition().getAbbreviation()));
	}
}
