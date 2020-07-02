package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.statistic;

public interface statisticService {
		
	List<statistic> getAllStatistic();
	
	statistic saveStatisticResult(statistic statisticName);
	
	statistic getOneByName(String name);
	
	Optional<statistic> getOneById(Integer statisticId);
	
	void deleteStatistic(Integer statisticId);
}
