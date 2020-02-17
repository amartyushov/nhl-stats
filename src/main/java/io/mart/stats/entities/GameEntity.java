package io.mart.stats.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Digits(integer = 10, fraction = 0)
	private BigDecimal id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date date;
	
	@Column
	private Integer away;
	
	@Column
	private Integer home;
}
