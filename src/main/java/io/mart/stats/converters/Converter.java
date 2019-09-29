package io.mart.stats.converters;

public interface Converter<SWAGGER, INTERNAL> {
	
	SWAGGER toSwagger(INTERNAL internal);
	
	INTERNAL fromSwagger(SWAGGER swagger);
	
}
