package io.mart.stats.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "games")
public class GameEntity extends AuditModel {
	
	@Id
	@Digits(integer = 10, fraction = 0)
	private BigDecimal id;
	
}
