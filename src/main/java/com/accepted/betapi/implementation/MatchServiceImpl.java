package com.accepted.betapi.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accepted.betapi.domain.Match;
import com.accepted.betapi.dto.MatchDto;
import com.accepted.betapi.repository.MatchRepository;
import com.accepted.betapi.service.MatchService;
import com.accepted.betapi.transformers.MatchToMatchDtoTransformer;

@Service
public class MatchServiceImpl implements MatchService {
	
	private final MatchRepository matchRepository;
	private final MatchToMatchDtoTransformer matchTransformer;
	
	@Autowired
	public MatchServiceImpl(MatchRepository matchRepository, MatchToMatchDtoTransformer matchTransformer) {
		super();
		this.matchRepository = matchRepository;
		this.matchTransformer = matchTransformer;
	}

	@Override
	public List<MatchDto> getAll() {
		List<MatchDto> matchesDtoList = new ArrayList<>();
		Iterable<Match> matches = matchRepository.findAll();
		
		for (Match match : matches) {
			matchesDtoList.add(matchTransformer.transform(match));
		}
		
		return matchesDtoList;
	}

	@Override
	public MatchDto getMatch(int id) {
		Match match = matchRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Not found Match with id = " + id));

		return matchTransformer.transform(match);
	}

	@Override
	public MatchDto create(Match match) {
		Match _match = matchRepository.save(match);
		return matchTransformer.transform(_match);
	}

	@Override
	public MatchDto update(int id, Match match) {
		Match updatableMatch = matchRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Not found Match with id = " + id));
		
		updatableMatch.setDescription(match.getDescription());
		updatableMatch.setMatchDate(match.getMatchDate());
		updatableMatch.setMatchTime(match.getMatchTime());
		updatableMatch.setTeamA(match.getTeamA());
		updatableMatch.setTeamB(match.getTeamB());
		updatableMatch.setSport(match.getSport());
		matchRepository.save(updatableMatch);
		
		return matchTransformer.transform(updatableMatch);
	}

	@Override
	public void deleteAll() {
		matchRepository.deleteAll();
	}

	@Override
	public void delete(int id) {
		Match match = matchRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Not found Match with id = " + id));
		
		matchRepository.deleteById(match.getId());
		
	}

}
