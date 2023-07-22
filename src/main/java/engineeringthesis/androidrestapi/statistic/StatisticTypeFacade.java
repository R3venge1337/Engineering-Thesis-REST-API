package engineeringthesis.androidrestapi.statistic;

import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticTypeForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticTypeDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticTypeForm;

import java.util.List;
import java.util.UUID;

public interface StatisticTypeFacade {
		
	List<StatisticTypeDto> getAllStatistic();
	
	StatisticTypeDto saveStatisticType(final CreateStatisticTypeForm statisticTypeForm);

	StatisticTypeDto findStatisticType(final UUID uuid);
	
	void updateStatisticType(final UUID uuid, final UpdateStatisticTypeForm statisticTypeForm);
	
	void deleteStatistic(final UUID uuid);
}
