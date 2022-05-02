package com.accepted.betapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MatchOdds")
public class MatchOdds {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "match_id", nullable = false)
	private Match match;
	@Column(name = "specifier", nullable = false, columnDefinition = "char(1)")
	private String specifier;
	@Column(name = "odd")
	private double odd;

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}
	
	public Match getMatch() {
	return match;
	}

	public void setMatch(Match match) {
	this.match = match;
	}

	public String getSpecifier() {
	return specifier;
	}

	public void setSpecifier(String specifier) {
	this.specifier = specifier;
	}

	public double getOdd() {
	return odd;
	}

	public void setOdd(Float odd) {
	this.odd = odd;
	}

}
