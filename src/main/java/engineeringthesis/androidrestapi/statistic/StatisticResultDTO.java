package engineeringthesis.androidrestapi.statistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class StatisticResultDTO {

	private Integer statisticResultsId;
	
	private String statisticResults;
	
	private StatisticTypeEntity statisticTypeId;
}
