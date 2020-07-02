package engineeringthesis.androidrestapi.service;

import java.util.List;
import java.util.Optional;

import engineeringthesis.androidrestapi.model.statisticResults;

public interface statisticResultsService {

	List<statisticResults> getAllStatisticResults();
	
	statisticResults saveStatisticResult(statisticResults statisticResultsName);
	
	statisticResults getOneByName(String name);
	
	Optional<statisticResults> getOneById(Integer statisticResultsId);
	
	void deleteStatisticResults(Integer statisticResultsId);
}
