package engineeringthesis.androidrestapi.mapper;

import org.springframework.stereotype.Component;

import engineeringthesis.androidrestapi.dto.StatisticTypeDTO;
import engineeringthesis.androidrestapi.entity.StatisticTypeEntity;

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
