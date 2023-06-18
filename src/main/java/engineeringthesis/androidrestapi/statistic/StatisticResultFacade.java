package engineeringthesis.androidrestapi.statistic;

import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDTO;

import java.util.List;

public interface StatisticResultFacade {

	List<StatisticResultDTO> getAllStatisticResults();
	
	StatisticResultDTO saveStatisticResult(StatisticResultDTO StatisticResultObj);
	
	StatisticResultDTO getOneByName(String name);
	
	StatisticResultDTO getOneById(Integer statisticResultsId);
	
	StatisticResultDTO updateStatisticResult(Integer statisticResultsId,StatisticResultDTO StatisticResultObj);
	
	void deleteStatisticResults(Integer statisticResultsId);
}
