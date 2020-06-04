package com.java.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.apache.commons.collections.CollectionUtils;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Transaction> transactions;
	@JsonInclude
	@Transient
	private Long totalRewardPoints;
	@JsonInclude
	@Transient
	private Double totalPurchases;
	
	@JsonInclude
	@Transient
	private Map<String,Integer> totalRewardsPerMonth;
	
	public Customer() {
		super();
	}
	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	
	public Map<String,Integer> getTotalRewardsPerMonth() {
		return transactions.stream().collect(
				Collectors.groupingBy(Transaction::getTrnxMonth,
						Collectors.summingInt(Transaction::getPoints)));
	}
	
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public Long getTotalRewardPoints() {
		return CollectionUtils.isEmpty(transactions) ? 0l
				: transactions.stream()
				.map(t -> t.getPoints().intValue())
				.reduce(0, (a, b) -> a + b).longValue();
	}

	public Double getTotalPurchases() {
		return CollectionUtils.isEmpty(transactions) ? 0d
				: transactions.stream()
				.map(t -> t.getTotal().doubleValue())
				.reduce(0d, (a, b) -> a + b).doubleValue();
	}
	
	
}
