package engineeringthesis.androidrestapi.statistic.controller;

import java.util.List;

import engineeringthesis.androidrestapi.statistic.StatisticResultFacade;
import engineeringthesis.androidrestapi.statistic.dto.StatisticResultDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/statistics/statisticResults")
@RequiredArgsConstructor
class StatisticResultController {

	
	private final StatisticResultFacade statisticResultServiceImpl;

	@GetMapping
	List<StatisticResultDTO> getAllStatisticResults() {
		return statisticResultServiceImpl.getAllStatisticResults();
	}

	@GetMapping(value = "/{statisticResultsId}")
	StatisticResultDTO getStatisticResultsById(@PathVariable Integer statisticResultsId) {
		return statisticResultServiceImpl.getOneById(statisticResultsId);
	}

	@PostMapping
	StatisticResultDTO saveStatisticResults(@RequestBody StatisticResultDTO statisticResultsObj) {
		return statisticResultServiceImpl.saveStatisticResult(statisticResultsObj);
	}

	@PutMapping(value = "/{statisticResultsId}")
	StatisticResultDTO updateStatisticResults(@RequestBody StatisticResultDTO statisticResultsObj,
			@PathVariable Integer statisticResultsId) {
		return statisticResultServiceImpl.updateStatisticResult(statisticResultsId, statisticResultsObj);
	}

	@DeleteMapping(value = "/{statisticResultsId}")
	void deleteStatisticResult(@PathVariable Integer statisticResultsId) {
		statisticResultServiceImpl.deleteStatisticResults(statisticResultsId);
	}
}