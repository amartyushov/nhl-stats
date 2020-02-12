package io.mart.stats.converters;

public interface Converter<Entity, Dto> {
	
	Dto toDto(Entity entity);
	
	Entity toEntity(Dto dto);
}
