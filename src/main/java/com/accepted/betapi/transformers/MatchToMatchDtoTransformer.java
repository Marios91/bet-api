package com.accepted.betapi.transformers;

import org.springframework.stereotype.Component;

import com.accepted.betapi.domain.Match;
import com.accepted.betapi.dto.MatchDto;

@Component
public class MatchToMatchDtoTransformer {
	
	public MatchDto transform(Match match) {
		
		MatchDto matchDto = new MatchDto();
		matchDto.setDescription(match.getDescription());
		matchDto.setMatchDate(match.getMatchDate());
		matchDto.setMatchTime(match.getMatchTime());
		matchDto.setTeamA(match.getTeamA());
		matchDto.setTeamB(match.getTeamB());
		matchDto.setSport(match.getSport().name());
		
		return matchDto;
	}
}
