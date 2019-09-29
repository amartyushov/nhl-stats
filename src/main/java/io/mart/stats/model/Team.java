package io.mart.stats.model;

import java.util.List;

import io.swagger.client.model.Player;


public class Team {
	
	private int id;
	private String name;
	private List<HockeyPlayer> players;
	
	
	public int getId() {
		return id;
	}
	
	
	public Team setId(int id) {
		this.id = id;
		return this;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public Team setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public List<HockeyPlayer> getPlayers() {
		return players;
	}
	
	
	public void addPlayer(HockeyPlayer player) {
		players.add(player);
	}
}
