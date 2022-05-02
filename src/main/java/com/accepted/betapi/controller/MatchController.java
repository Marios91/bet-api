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
import com.accepted.betapi.dto.MatchDto;
import com.accepted.betapi.service.MatchService;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {

	private final MatchService matchService;

	@Autowired
	public MatchController(MatchService matchService) {
		super();
		this.matchService = matchService;
	}

	@GetMapping("/all")
	public List<MatchDto> getAllMatches() {
		return matchService.getAll();
	}

	@GetMapping("/one/{id}")
	public MatchDto getMatchById(@PathVariable("id") int id) {
		return matchService.getMatch(id);
	}

	@PostMapping("/new")
	public MatchDto createMatch(@RequestBody Match match) {
		return matchService.create(match);
	}
	
	@PutMapping("/update/{id}")
	public MatchDto updateMatch(@PathVariable("id") int id, @RequestBody Match match) {
		return matchService.update(id, match);
	}
	
	@DeleteMapping("/all")
	public void deleteAllMatches() {
		matchService.deleteAll();
	}
	
	@DeleteMapping("/one/{id}")
	public void deleteMatch(@PathVariable("id") int id) {
		matchService.delete(id);
	}

}
