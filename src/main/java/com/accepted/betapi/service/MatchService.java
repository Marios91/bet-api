package com.accepted.betapi.service;

import java.util.List;

import com.accepted.betapi.domain.Match;
import com.accepted.betapi.dto.MatchDto;

public interface MatchService {
	
	List<MatchDto> getAll();
	
	MatchDto getMatch(int id);
	
	MatchDto create(Match match);
	
	MatchDto update(int id, Match match);
	
	void deleteAll();
	
	void delete(int id);

}
