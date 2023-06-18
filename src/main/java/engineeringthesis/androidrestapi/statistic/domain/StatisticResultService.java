package engineeringthesis.androidrestapi.statistic.domain;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import engineeringthesis.androidrestapi.statistic.StatisticResultFacade;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDTO;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class StatisticResultService implements StatisticResultFacade {
	

	private final StatisticResultRepository statisticResultRepository;
	private final StatisticResultMapper statisticResultMapper;

	@Override
	public List<StatisticResultDTO> getAllStatisticResults() {
		return statisticResultMapper.mapOfCollection(statisticResultRepository.findAll());
	}

	@Override
	public StatisticResultDTO saveStatisticResult(StatisticResultDTO statisticResultObj) {
		
		StatisticResult statisticResultEntity = statisticResultMapper.mapOfDTO(statisticResultObj);
		StatisticResult savedEntity = statisticResultRepository.save(statisticResultEntity);
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
		
		Optional<StatisticResult> statisticResultEntity = statisticResultRepository.findById(statisticResultsId);
		StatisticResult savedEntity = statisticResultEntity.get();
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
