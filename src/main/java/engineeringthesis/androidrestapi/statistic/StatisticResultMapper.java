package engineeringthesis.androidrestapi.statistic;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;

@Component
public class StatisticResultMapper implements Mapper<StatisticResultDTO,StatisticResultEntity> {

	@Override
	public StatisticResultDTO mapOfEntity(StatisticResultEntity entity) {
		
		StatisticResultDTO statisticResultDTO = StatisticResultDTO.builder()
				.statisticResultsId(entity.getStatisticResultsId())
				.statisticResults(entity.getStatisticResults())
				.statisticTypeId(entity.getStatisticId())
				.build();
		return statisticResultDTO;
	}

	@Override
	public StatisticResultEntity mapOfDTO(StatisticResultDTO dto) {
		
		StatisticResultEntity statisticResultEntity = StatisticResultEntity.builder()
				.statisticResultsId(dto.getStatisticResultsId())
				.statisticResults(dto.getStatisticResults())
				.statisticId(dto.getStatisticTypeId())
				.build();
		return statisticResultEntity;
	}

}
