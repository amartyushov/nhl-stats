package io.mart.stats.model.enums;

import java.math.BigDecimal;

public enum Seasons {
	CURRENT(null);
	
	private BigDecimal seasonAsDecimal;
	
	
	Seasons(BigDecimal s) {
		seasonAsDecimal = s;
	}
	
	
	public BigDecimal get() {
		return seasonAsDecimal;
	}
}