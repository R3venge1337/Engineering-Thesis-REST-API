package engineeringthesis.androidrestapi.statistic;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.util.Mapper;

@Component
public class StatisticTypeMapper implements Mapper<StatisticTypeDTO,StatisticTypeEntity> {

	@Override
	public StatisticTypeDTO mapOfEntity(StatisticTypeEntity entity) {
		
		StatisticTypeDTO statisticTypeDTO = StatisticTypeDTO.builder()
				.statisticId(entity.getStatisticId())
				.statisticName(entity.getStatisticName())
				.build();
		
		return statisticTypeDTO;
	}

	@Override
	public StatisticTypeEntity mapOfDTO(StatisticTypeDTO dto) {
		 
		StatisticTypeEntity statisticTypeEntity =  StatisticTypeEntity.builder()
				.statisticId(dto.getStatisticId())
				.statisticName(dto.getStatisticName())
				 .build();
		
		return statisticTypeEntity;
	}

}
