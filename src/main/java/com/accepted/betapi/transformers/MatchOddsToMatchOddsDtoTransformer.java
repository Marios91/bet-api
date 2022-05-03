package com.accepted.betapi.transformers;

import org.springframework.stereotype.Component;

import com.accepted.betapi.domain.MatchOdds;
import com.accepted.betapi.dto.MatchDto;
import com.accepted.betapi.dto.MatchOddsDto;

@Component
public class MatchOddsToMatchOddsDtoTransformer {
	
	public MatchOddsDto transform(MatchOdds matchOdds, MatchDto matchDto) {
		
		MatchOddsDto matchOddsDto = new MatchOddsDto();
		matchOddsDto.setMatch(matchDto);
		matchOddsDto.setOdd(matchOdds.getOdd());
		matchOddsDto.setSpecifier(matchOdds.getSpecifier());
		
		return matchOddsDto;
	}
	
}
