package io.mart.stats.entities.enums;

public enum Expands {
	
	EMPTY(null);
	
	
	private String value;
	
	
	Expands(String value) {
		this.value = value;
	}
	
	
	public String getValue() {
		return value;
	}
}
