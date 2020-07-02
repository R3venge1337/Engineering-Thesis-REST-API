package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.statisticResults;
import engineeringthesis.androidrestapi.repository.statisticResultsRepository;
import engineeringthesis.androidrestapi.service.statisticResultsService;

@Service
@Transactional
public class statisticResultsServiceImpl implements statisticResultsService {
	
	@Autowired
	statisticResultsRepository statisticResultsRepo;

	@Override
	public List<statisticResults> getAllStatisticResults() {
		return statisticResultsRepo.findAll();
	}

	@Override
	public statisticResults saveStatisticResult(statisticResults statisticResultsName) {
		return statisticResultsRepo.save(statisticResultsName);
	}

	@Override
	public statisticResults getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<statisticResults> getOneById(Integer statisticResultsId) {
		return statisticResultsRepo.findById(statisticResultsId);
	}

	@Override
	public void deleteStatisticResults(Integer statisticResultsId) {
		statisticResultsRepo.deleteById(statisticResultsId);
		
	}
}
