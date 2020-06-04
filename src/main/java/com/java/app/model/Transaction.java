package com.java.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Transaction {
	@Id
	@GeneratedValue
	private Integer id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Customer customer;
	private Double total;
	private String description;
	private String trnxMonth;
	@Temporal(TemporalType.TIMESTAMP)
	private Date trnxDate;
	
	@JsonInclude 
	@Transient 
	private Integer points;
	
	
	public Transaction() {
		super();
	}
	
	public Transaction(Integer id, Double total, String description, Date date) {
		super();
		this.id = id;
		this.total = total;
		this.description = description;
		this.setTrnxDate(date);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrnxMonth() {
		return trnxMonth;
	}

	public void setTrnxMonth(String trnxMonth) {
		this.trnxMonth = trnxMonth;
	}
	
	@Override
	public String toString() {
		return String.format("Transaction [id=%s, total=%s, description=%s, trnxDate=%s]", id,
				total, description, trnxDate);
	}

	public Date getTrnxDate() {
		return trnxDate;
	}

	public void setTrnxDate(Date trnxDate) {
		this.trnxDate = trnxDate;
	}
	
	public Integer getPoints() {
		this.points = 0;
		
		if (this.total > 50 && this.total <= 100) {
			this.points += (this.total.intValue() - 50) * 1;
			
		} 
		
		if (this.total > 100) {
			this.points += 50;  
			this.points += (this.total.intValue() - 100) * 2; 
		}
		
		return this.points;
	}

	
}

