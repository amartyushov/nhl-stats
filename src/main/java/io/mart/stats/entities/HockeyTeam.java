package io.mart.stats.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class HockeyTeam extends AuditModel {
	
	@Id
	private Integer id;
	private String name;
}
