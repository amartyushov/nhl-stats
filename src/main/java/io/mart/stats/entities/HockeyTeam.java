package io.mart.stats.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class HockeyTeam {
	
	@Id
	private Integer id;
	
	
	private String name;
	
	
	public int getId() {
		return id;
	}
	
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	
	public HockeyTeam setId(int id) {
		this.id = id;
		return this;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public HockeyTeam setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public HockeyTeam setId(Integer id) {
		this.id = id;
		return this;
	}
	
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	
	public HockeyTeam setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	
	public HockeyTeam setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}
}
