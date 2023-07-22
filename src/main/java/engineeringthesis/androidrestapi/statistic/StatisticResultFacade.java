package engineeringthesis.androidrestapi.statistic;

import engineeringthesis.androidrestapi.statistic.dto.CreateStatisticResultForm;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDto;
import engineeringthesis.androidrestapi.statistic.dto.UpdateStatisticResultForm;

import java.util.List;
import java.util.UUID;

public interface StatisticResultFacade {

	List<StatisticResultDto> getAllStatisticResults();
	
	StatisticResultDto saveStatisticResult(final CreateStatisticResultForm resultForm);

	StatisticResultDto findStatisticResult(final UUID uuid);
	
	void updateStatisticResult(final UUID uuid, final UpdateStatisticResultForm resultForm);
	
	void deleteStatisticResults(final UUID uuid);
}
