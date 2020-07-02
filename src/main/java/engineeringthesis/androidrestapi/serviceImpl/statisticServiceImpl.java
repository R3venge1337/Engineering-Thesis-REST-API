package engineeringthesis.androidrestapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineeringthesis.androidrestapi.model.statistic;
import engineeringthesis.androidrestapi.repository.statisticRepository;
import engineeringthesis.androidrestapi.service.statisticService;

@Service
@Transactional
public class statisticServiceImpl implements statisticService {

	@Autowired
	statisticRepository statisticRepo;

	@Override
	public List<statistic> getAllStatistic() {
		return statisticRepo.findAll();
	}

	@Override
	public statistic saveStatisticResult(statistic statisticObj) {
		return statisticRepo.save(statisticObj);
	}

	@Override
	public statistic getOneByName(String name) {
		return null;
	}

	@Override
	public Optional<statistic> getOneById(Integer statisticId) {
		return statisticRepo.findById(statisticId);
	}

	@Override
	public void deleteStatistic(Integer statisticId) {
		statisticRepo.deleteById(statisticId);
	}
}
