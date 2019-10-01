package io.mart.stats.model;

import io.mart.stats.model.enums.Nationality;
import io.mart.stats.model.enums.Position;

public class HockeyPlayer {
	
	private int id;
	private String name;
	private Nationality nationality;
	private Position position;
	
	
	public HockeyPlayer() {
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public Nationality getNationality() {
		return nationality;
	}
	
	
	public Position getPosition() {
		return position;
	}
	
	
	public HockeyPlayer setId(int id) {
		this.id = id;
		return this;
	}
	
	
	public HockeyPlayer setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public HockeyPlayer setNationality(Nationality nationality) {
		this.nationality = nationality;
		return this;
	}
	
	
	public HockeyPlayer setPosition(Position position) {
		this.position = position;
		return this;
	}
}
