package io.mart.stats.model;

import io.mart.stats.model.enums.Nationality;
import io.mart.stats.model.enums.Position;

public class HockeyPlayer {
	
	private final int id;
	private final String name;
	private final Nationality nationality;
	private final Position position;
	
	
	public HockeyPlayer(HockeyPlayerBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.nationality = builder.nationality;
		this.position = builder.position;
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
	
	
	public static class HockeyPlayerBuilder {
		
		private int id;
		private String name;
		private Nationality nationality;
		private Position position;
		
		
		private HockeyPlayerBuilder() {
		}
		
		
		public static HockeyPlayerBuilder newInstance() {
			return new HockeyPlayerBuilder();
		}
		
		
		public HockeyPlayerBuilder id(int id) {
			this.id = id;
			return this;
		}
		
		
		public HockeyPlayerBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		
		public HockeyPlayerBuilder nationality(Nationality nationality) {
			this.nationality = nationality;
			return this;
		}
		
		
		public HockeyPlayerBuilder position(Position position) {
			this.position = position;
			return this;
		}
		
		
		public HockeyPlayer build() {
			return new HockeyPlayer(this);
		}
	}
}
