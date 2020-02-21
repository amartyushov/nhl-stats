package io.mart.stats.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity(name = "games")
public class GameEntity extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Digits(integer = 10, fraction = 0)
	private BigDecimal gameId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date date;
	
	@Column(name = "away_score")
	private Integer awayScore;
	
	@Column(name = "home_score")
	private Integer homeScore;
	
	@ManyToOne
	@JoinColumn(name = "away_team_id", referencedColumnName = "team_id")
	private TeamEntity awayTeam;
	
	@ManyToOne
	@JoinColumn(name = "home_team_id", referencedColumnName = "team_id")
	private TeamEntity homeTeam;
	
}
