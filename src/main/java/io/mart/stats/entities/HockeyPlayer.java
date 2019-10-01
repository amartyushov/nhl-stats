package io.mart.stats.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import io.mart.stats.entities.enums.Nationality;
import io.mart.stats.entities.enums.Position;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class HockeyPlayer extends AuditModel {
	
	@Id
	private int id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Nationality nationality;
	@Enumerated(EnumType.STRING)
	private Position position;
	
}
