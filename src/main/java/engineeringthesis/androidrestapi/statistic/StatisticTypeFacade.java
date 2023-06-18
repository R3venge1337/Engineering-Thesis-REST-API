package engineeringthesis.androidrestapi.statistic;

import engineeringthesis.androidrestapi.statistic.dto.StatisticTypeDTO;

import java.util.List;

public interface StatisticTypeFacade {
		
	List<StatisticTypeDTO> getAllStatistic();
	
	StatisticTypeDTO saveStatisticType(StatisticTypeDTO statisticTypeObj);
	
	StatisticTypeDTO getOneByName(String name);
	
	StatisticTypeDTO getOneById(Integer statisticId);
	
	StatisticTypeDTO updateStatisticType(Integer statisticId,StatisticTypeDTO statisticTypeObj);
	
	void deleteStatistic(Integer statisticId);
}
