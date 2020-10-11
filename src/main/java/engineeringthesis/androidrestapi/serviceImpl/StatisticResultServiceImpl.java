package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.dto.StatisticResultDTO;
import engineeringthesis.androidrestapi.entity.StatisticResultEntity;
import engineeringthesis.androidrestapi.mapper.StatisticResultMapper;
import engineeringthesis.androidrestapi.repository.StatisticResultRepository;
import engineeringthesis.androidrestapi.service.StatisticResultService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StatisticResultServiceImpl implements StatisticResultService {
	

	private final StatisticResultRepository statisticResultRepository;
	private final StatisticResultMapper statisticResultMapper;

	@Override
	public List<StatisticResultDTO> getAllStatisticResults() {
		return statisticResultMapper.mapOfCollection(statisticResultRepository.findAll());
	}

	@Override
	public StatisticResultDTO saveStatisticResult(StatisticResultDTO statisticResultObj) {
		
		StatisticResultEntity statisticResultEntity = statisticResultMapper.mapOfDTO(statisticResultObj);
		StatisticResultEntity savedEntity = statisticResultRepository.save(statisticResultEntity);
		return statisticResultMapper.mapOfEntity(savedEntity);
	}

	@Override
	public StatisticResultDTO getOneByName(String name) {
		return null;
	}

	@Override
	public StatisticResultDTO getOneById(Integer statisticResultsId) {
		return statisticResultMapper.mapOfEntity(statisticResultRepository.findById(statisticResultsId).get());
	}
	
	@Override
	public StatisticResultDTO updateStatisticResult(Integer statisticResultsId, StatisticResultDTO StatisticResultObj) {
		
		Optional<StatisticResultEntity> statisticResultEntity = statisticResultRepository.findById(statisticResultsId);
		StatisticResultEntity savedEntity = statisticResultEntity.get();
		savedEntity.setStatisticResults(StatisticResultObj.getStatisticResults());
		statisticResultRepository.save(savedEntity);
		StatisticResultDTO dto = statisticResultMapper.mapOfEntity(savedEntity);
		return dto;
	}

	@Override
	public void deleteStatisticResults(Integer statisticResultsId) {
		statisticResultRepository.deleteById(statisticResultsId);
		
	}

	
}
