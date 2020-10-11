package engineeringthesis.androidrestapi.dto;

import engineeringthesis.androidrestapi.entity.GameplayEntity;
import engineeringthesis.androidrestapi.entity.StatisticResultEntity;
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
	
	private StatisticResultEntity statisticResultsId;
}
