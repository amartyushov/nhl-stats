package io.mart.stats.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity(name = "teams")
@Getter
@Setter
@Accessors(chain = true)
public class TeamEntity extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "team_id")
	private Integer teamId;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "awayTeam")
	private Set<GameEntity> awayTeams = new HashSet<>();
	
	@OneToMany(mappedBy = "homeTeam")
	private Set<GameEntity> homeTeams = new HashSet<>();
	
	@ManyToMany(mappedBy = "teams")
	private Set<PlayerEntity> players = new HashSet<>();
	
}
