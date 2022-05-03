package com.accepted.betapi.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accepted.betapi.domain.Match;
import com.accepted.betapi.domain.MatchOdds;
import com.accepted.betapi.dto.MatchDto;
import com.accepted.betapi.dto.MatchOddsDto;
import com.accepted.betapi.repository.MatchOddsRepository;
import com.accepted.betapi.repository.MatchRepository;
import com.accepted.betapi.service.MatchOddsService;
import com.accepted.betapi.transformers.MatchOddsToMatchOddsDtoTransformer;
import com.accepted.betapi.transformers.MatchToMatchDtoTransformer;

@Service
public class MatchOddsServiceImpl implements MatchOddsService {
	
	private final MatchRepository matchRepository;
	private final MatchOddsRepository matchOddsRepository;
	private final MatchToMatchDtoTransformer matchTransformer;
	private final MatchOddsToMatchOddsDtoTransformer matchOddsTransformer;
	
	@Autowired
	public MatchOddsServiceImpl(MatchRepository matchRepository,
			MatchOddsRepository matchOddsRepository, 
			MatchToMatchDtoTransformer matchTransformer, 
			MatchOddsToMatchOddsDtoTransformer matchOddsTransformer) {
		super();
		this.matchRepository = matchRepository;
		this.matchOddsRepository = matchOddsRepository;
		this.matchTransformer = matchTransformer;
		this.matchOddsTransformer = matchOddsTransformer;
	}


	@Override
	public List<MatchOddsDto> getAll(int matchId) {
		
		List<MatchOddsDto> matchOddsDtoList = new ArrayList<>();
		if (!matchRepository.existsById(matchId)) {
			throw new NoSuchElementException("Not found Match with id = " + matchId);
		}
		Match match = matchRepository.findById(matchId).get();
		List<MatchOdds> matchOdds = matchOddsRepository.findByMatch(match);
		
		for (MatchOdds matchOdd : matchOdds) {
			MatchDto matchDto = matchTransformer.transform(matchOdd.getMatch());
			matchOddsDtoList.add(matchOddsTransformer.transform(matchOdd, matchDto));
		}
		
		return matchOddsDtoList;
	}


	@Override
	public MatchOddsDto getMatchOdds(int id) {
	
		MatchOdds matchOdd = matchOddsRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Not found Match Odd with id = " + id));
		
		MatchDto matchDto = matchTransformer.transform(matchOdd.getMatch());
		return matchOddsTransformer.transform(matchOdd, matchDto);
	}


	@Override
	public MatchOddsDto create(int matchId, MatchOdds matchOddRequest) {
		MatchOdds matchOdd = matchRepository.findById(matchId)
				.map(match -> saveMatchOddToDB(matchOddRequest, match))
				.orElseThrow(() -> new NoSuchElementException("Not found Match with id = " + matchId));
		MatchDto matchDto = matchTransformer.transform(matchOdd.getMatch());
		
		return matchOddsTransformer.transform(matchOdd, matchDto);
	}
	
	private MatchOdds saveMatchOddToDB(MatchOdds matchOddRequest, Match match) {
		matchOddRequest.setMatch(match);
		return matchOddsRepository.save(matchOddRequest);
	}


	@Override
	public MatchOddsDto update(int id, MatchOdds matchOddRequest) {
		MatchOdds matchOdd = matchOddsRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Not found Match Odd with id = " + id));
		matchOdd.setOdd(matchOddRequest.getOdd());
		matchOdd.setSpecifier(matchOddRequest.getSpecifier());
		matchOddsRepository.save(matchOdd);
		MatchDto matchDto = matchTransformer.transform(matchOdd.getMatch());
		
		return matchOddsTransformer.transform(matchOdd, matchDto);
	}


	@Override
	public void delete(int id) {
		if (!matchOddsRepository.existsById(id)) {
			throw new NoSuchElementException("Not found Match Odd with id = " + id);
		}
		matchOddsRepository.deleteById(id);
	}


	@Override
	public void deleteMatchOdds(int matchId) {
		Match match = matchRepository.findById(matchId)
				.orElseThrow(() -> new NoSuchElementException("Not found Match with id = " + matchId));
		
		matchOddsRepository.deleteByMatch(match);
	}

}
