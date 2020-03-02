package io.mart.stats.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import io.mart.stats.entities.enums.Nationality;
import io.mart.stats.entities.enums.Position;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "players")
public class PlayerEntity extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Digits(integer = 10, fraction = 0)
	@Column(name = "player_id")
	private BigDecimal playerId;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Enumerated(EnumType.STRING)
	private Nationality nationality;
	
	@Enumerated(EnumType.STRING)
	private Position position;
	
	private Integer jerseyNumber;
	
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "players_to_teams",
			joinColumns = @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "FK_player_id_mapping")),
			inverseJoinColumns = @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "FK_team_id_mapping"))
	)
	private Set<TeamEntity> teams = new HashSet<>();
	
	
	public PlayerEntity setTeam(TeamEntity team) {
		teams.add(team);
		return this;
	}
}
