package com.accepted.betapi.dto;

public class MatchOddsDto {
	
	private MatchDto match;
	private byte specifier;
	private double odd;
	
	public MatchDto getMatch() {
		return match;
	}
	public void setMatch(MatchDto match) {
		this.match = match;
	}
	public byte getSpecifier() {
		return specifier;
	}
	public void setSpecifier(byte specifier) {
		this.specifier = specifier;
	}
	public double getOdd() {
		return odd;
	}
	public void setOdd(double odd) {
		this.odd = odd;
	}

}
