package engineeringthesis.androidrestapi.statistic;

import engineeringthesis.androidrestapi.common.controller.PageDto;
import engineeringthesis.androidrestapi.common.controller.PageableRequest;
import engineeringthesis.androidrestapi.common.controller.UuidDto;
import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticTypeForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticFilterForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticTypeDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticTypeForm;

import java.util.List;
import java.util.UUID;

public interface StatisticTypeFacade {
		
	PageDto<StatisticTypeDto> findStatistics(final StatisticFilterForm filterForm, final PageableRequest pageableRequest);
	
	UuidDto saveStatisticType(final CreateStatisticTypeForm createForm);

	StatisticTypeDto findStatisticType(final UUID uuid);
	
	void updateStatisticType(final UUID uuid, final UpdateStatisticTypeForm updateForm);
	
	void deleteStatistic(final UUID uuid);
}
