package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class StatisticResultMapper implements Mapper<StatisticResultDTO, StatisticResult> {

	@Override
	public StatisticResultDTO mapOfEntity(StatisticResult entity) {
		
		StatisticResultDTO statisticResultDTO = StatisticResultDTO.builder()
				.statisticResultsId(entity.getStatisticResultsId())
				.statisticResults(entity.getStatisticResults())
				.statisticTypeId(entity.getStatisticId())
				.build();
		return statisticResultDTO;
	}

	@Override
	public StatisticResult mapOfDTO(StatisticResultDTO dto) {
		
		StatisticResult statisticResultEntity = StatisticResult.builder()
				.statisticResultsId(dto.getStatisticResultsId())
				.statisticResults(dto.getStatisticResults())
				.statisticId(dto.getStatisticTypeId())
				.build();
		return statisticResultEntity;
	}

}
