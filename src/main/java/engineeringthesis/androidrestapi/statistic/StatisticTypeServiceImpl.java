package engineeringthesis.androidrestapi.statistic;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class StatisticTypeServiceImpl implements StatisticTypeService {

	
	private final StatisticTypeRepository statisticTypeRepository;
	private final StatisticTypeMapper statisticTypeMapper;

	@Override
	public List<StatisticTypeDTO> getAllStatistic() {
		return statisticTypeMapper.mapOfCollection(statisticTypeRepository.findAll());
	}

	@Override
	public StatisticTypeDTO saveStatisticType(StatisticTypeDTO statisticTypeObj) {
		
		StatisticTypeEntity statisticTypeEntity = statisticTypeMapper.mapOfDTO(statisticTypeObj);
		StatisticTypeEntity savedEntity = statisticTypeRepository.save(statisticTypeEntity);
		return statisticTypeMapper.mapOfEntity(savedEntity);
	}

	@Override
	public StatisticTypeDTO getOneByName(String name) {
		return null;
	}

	@Override
	public StatisticTypeDTO getOneById(Integer statisticId) {
		return statisticTypeMapper.mapOfEntity(statisticTypeRepository.findById(statisticId).get());
	}
	
	@Override
	public StatisticTypeDTO updateStatisticType(Integer statisticId, StatisticTypeDTO statisticTypeObj) {
		
		Optional<StatisticTypeEntity> gameEntity = statisticTypeRepository.findById(statisticId);
		StatisticTypeEntity savedEntity = gameEntity.get();
		savedEntity.setStatisticName(statisticTypeObj.getStatisticName());
		statisticTypeRepository.save(savedEntity);
		StatisticTypeDTO dto = statisticTypeMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteStatistic(Integer statisticId) {
		statisticTypeRepository.deleteById(statisticId);
	}

	
}
