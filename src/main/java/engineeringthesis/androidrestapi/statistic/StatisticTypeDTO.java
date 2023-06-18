package engineeringthesis.androidrestapi.statistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class StatisticTypeDTO {
	
	private Integer statisticId;
	
	private String statisticName;
}