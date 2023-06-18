package engineeringthesis.androidrestapi.game.dto;

import engineeringthesis.androidrestapi.game.domain.GameplayEntity;
import engineeringthesis.androidrestapi.statistic.domain.StatisticResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class GameplayResultDTO {

	private Integer gameplayResultsId;
	
	private GameplayEntity gameplayId;
	
	private StatisticResult statisticResultsId;
}
