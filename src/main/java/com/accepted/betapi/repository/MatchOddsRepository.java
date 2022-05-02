package com.accepted.betapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.accepted.betapi.domain.Match;
import com.accepted.betapi.domain.MatchOdds;

public interface MatchOddsRepository extends CrudRepository<MatchOdds, Integer> {
	
	List<MatchOdds> findByMatch(Match match);
	
	@Transactional
	void deleteByMatchId(Match match);

}
