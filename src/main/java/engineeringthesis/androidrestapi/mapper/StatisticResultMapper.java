package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.StatisticResultDTO;
import engineeringthesis.androidrestapi.entity.StatisticResultEntity;

@Component
public class StatisticResultMapper implements Mapper<StatisticResultDTO,StatisticResultEntity> {

	@Override
	public StatisticResultDTO mapOfEntity(StatisticResultEntity entity) {
		
		StatisticResultDTO statisticResultDTO = StatisticResultDTO.builder()
				.statisticResults(entity.getStatisticResults())
				.build();
		return statisticResultDTO;
	}

	@Override
	public StatisticResultEntity mapOfDTO(StatisticResultDTO dto) {
		
		StatisticResultEntity statisticResultEntity = StatisticResultEntity.builder()
				.statisticResults(dto.getStatisticResults())
				.build();
		return statisticResultEntity;
	}

}
