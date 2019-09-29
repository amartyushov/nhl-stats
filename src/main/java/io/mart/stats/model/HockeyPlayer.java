package io.mart.stats.model;

public class HockeyPlayer {
	
	private int id;
	private String name;
	private Nationality nationality;
	
	
	public int getId() {
		return id;
	}
	
	
	public HockeyPlayer setId(int id) {
		this.id = id;
		return this;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public HockeyPlayer setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public Nationality getNationality() {
		return nationality;
	}
	
	
	public HockeyPlayer setNationality(Nationality nationality) {
		this.nationality = nationality;
		return this;
	}
}
