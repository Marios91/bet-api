package com.accepted.betapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.accepted.betapi.domain.Match;
import com.accepted.betapi.enums.SportTypes;

public interface MatchRepository extends CrudRepository<Match, Integer> {

	List<Match> findBySport(SportTypes sportType);
}
