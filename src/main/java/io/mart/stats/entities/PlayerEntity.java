package io.mart.stats.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class PlayerEntity extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Digits(integer = 10, fraction = 0)
	private BigDecimal playerId;
	
	private String fullName;
	
	@Enumerated(EnumType.STRING)
	private Nationality nationality;
	
	@Enumerated(EnumType.STRING)
	private Position position;
	
	private Integer jerseyNumber;
	
}
