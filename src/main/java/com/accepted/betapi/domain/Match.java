package com.accepted.betapi.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.accepted.betapi.enums.SportTypes;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Match {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "description")
	private String description;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
	@Column(name = "match_date", nullable = false)
	private LocalDate matchDate;
	@Column(name = "match_time", nullable = false)
	private LocalTime matchTime;
	@Column(name = "team_a")
	private String teamA;
	@Column(name = "team_b")
	private String teamB;
	@Column(name = "sport", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private SportTypes sport;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}

	public LocalTime getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(LocalTime matchTime) {
		this.matchTime = matchTime;
	}

	public String getTeamA() {
		return teamA;
	}

	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}

	public String getTeamB() {
		return teamB;
	}

	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}

	public SportTypes getSport() {
		return sport;
	}

	public void setSport(SportTypes sport) {
		this.sport = sport;
	}

}
