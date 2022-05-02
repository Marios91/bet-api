package com.accepted.betapi.dto;

public class MatchOddsDto {
	
	private MatchDto match;
	private char specifier;
	private float odd;
	
	public MatchDto getMatch() {
		return match;
	}
	public void setMatch(MatchDto match) {
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
