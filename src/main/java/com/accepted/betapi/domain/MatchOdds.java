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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "MatchOdds")
public class MatchOdds {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "match_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Match match;
	
	@Column(name = "specifier", nullable = false, columnDefinition = "char(1)")
	private char specifier;
	
	@Column(name = "odd", nullable = false)
	private float odd;

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

	public char getSpecifier() {
	return specifier;
	}

	public void setSpecifier(char specifier) {
	this.specifier = specifier;
	}

	public float getOdd() {
	return odd;
	}

	public void setOdd(float odd) {
	this.odd = odd;
	}

}
