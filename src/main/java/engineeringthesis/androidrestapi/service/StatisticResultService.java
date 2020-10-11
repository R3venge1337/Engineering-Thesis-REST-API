package engineeringthesis.androidrestapi.service;

import java.util.List;

import engineeringthesis.androidrestapi.dto.StatisticResultDTO;

public interface StatisticResultService {

	List<StatisticResultDTO> getAllStatisticResults();
	
	StatisticResultDTO saveStatisticResult(StatisticResultDTO StatisticResultObj);
	
	StatisticResultDTO getOneByName(String name);
	
	StatisticResultDTO getOneById(Integer statisticResultsId);
	
	StatisticResultDTO updateStatisticResult(Integer statisticResultsId,StatisticResultDTO StatisticResultObj);
	
	void deleteStatisticResults(Integer statisticResultsId);
}
