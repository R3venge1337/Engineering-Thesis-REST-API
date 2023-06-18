package engineeringthesis.androidrestapi.statistic.domain;

import engineeringthesis.androidrestapi.statistic.dto.StatisticTypeDTO;
import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.common.entity.Mapper;

@Component
class StatisticTypeMapper implements Mapper<StatisticTypeDTO, StatisticType> {

	@Override
	public StatisticTypeDTO mapOfEntity(StatisticType entity) {
		
		StatisticTypeDTO statisticTypeDTO = StatisticTypeDTO.builder()
				.statisticId(entity.getStatisticId())
				.statisticName(entity.getStatisticName())
				.build();
		
		return statisticTypeDTO;
	}

	@Override
	public StatisticType mapOfDTO(StatisticTypeDTO dto) {
		 
		StatisticType statisticTypeEntity =  StatisticType.builder()
				.statisticId(dto.getStatisticId())
				.statisticName(dto.getStatisticName())
				 .build();
		
		return statisticTypeEntity;
	}

}
