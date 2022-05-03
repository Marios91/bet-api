package com.accepted.betapi.service;

import java.util.List;

import com.accepted.betapi.domain.MatchOdds;
import com.accepted.betapi.dto.MatchOddsDto;

public interface MatchOddsService {
	
	List<MatchOddsDto> getAll(int matchId);
	
	MatchOddsDto getMatchOdds(int id);
	
	MatchOddsDto create(int matchId, MatchOdds matchOddRequest);
	
	MatchOddsDto update(int matchId, MatchOdds matchOddRequest);
	
	void delete(int id);
	
	void deleteMatchOdds(int matchId);

}
