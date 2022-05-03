package com.accepted.betapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accepted.betapi.domain.Match;
import com.accepted.betapi.domain.MatchOdds;
import com.accepted.betapi.dto.MatchDto;
import com.accepted.betapi.dto.MatchOddsDto;
import com.accepted.betapi.service.MatchOddsService;
import com.accepted.betapi.service.MatchService;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {

	private final MatchService matchService;
	private final MatchOddsService matchOddsService;

	@Autowired
	public MatchController(MatchService matchService, MatchOddsService matchOddsService) {
		super();
		this.matchService = matchService;
		this.matchOddsService = matchOddsService;
	}

	@GetMapping("/all")
	public List<MatchDto> getAllMatches() {
		return matchService.getAll();
	}
	
	@GetMapping("/{matchId}/odds")
	public List<MatchOddsDto> getAllMatchOddsByMatchId(@PathVariable("matchId") int matchId) {
		return matchOddsService.getAll(matchId);
	}

	@GetMapping("/one/{id}")
	public MatchDto getMatchById(@PathVariable("id") int id) {
		return matchService.getMatch(id);
	}
	
	@GetMapping("/odds/{id}")
	public MatchOddsDto getMatchOddsByMatchId(@PathVariable("id") int id) {
		return matchOddsService.getMatchOdds(id);
	}

	@PostMapping("/new")
	public MatchDto createMatch(@RequestBody Match match) {
		return matchService.create(match);
	}
	
	@PostMapping("/{matchId}/odds/new")
	public MatchOddsDto createMatchOdds(@PathVariable("matchId") int matchId, @RequestBody MatchOdds matchOddRequest) {
		return matchOddsService.create(matchId, matchOddRequest);
	}
	
	@PutMapping("/update/{id}")
	public MatchDto updateMatch(@PathVariable("id") int id, @RequestBody Match match) {
		return matchService.update(id, match);
	}
	
	@PutMapping("/odds/update/{id}")
	public MatchOddsDto updateMatchOdds(@PathVariable("id") int id, @RequestBody MatchOdds matchOddRequest) {
		return matchOddsService.update(id, matchOddRequest);
	}
	
	@DeleteMapping("/delete/all")
	public void deleteAllMatches() {
		matchService.deleteAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMatch(@PathVariable("id") int id) {
		matchService.delete(id);
	}
	
	@DeleteMapping("/odds/delete/{id}")
	public void deleteMatchOdds(@PathVariable("id") int id) {
		matchOddsService.delete(id);
	}
	
	@DeleteMapping("/{matchId}/odds/delete")
	public void deleteAllMatchOddsFromMatch(@PathVariable("matchId") int matchId) {
		matchOddsService.deleteMatchOdds(matchId);
	}

}
