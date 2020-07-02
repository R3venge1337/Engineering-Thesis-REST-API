package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.model.statisticResults;
import engineeringthesis.androidrestapi.serviceImpl.statisticResultsServiceImpl;

@RestController
public class statisticResultsController {
	
	@Autowired
	statisticResultsServiceImpl statisticResultsServiceImpl;
	
	//@GetMapping
    @RequestMapping(value="/statistic/statisticResults",method = RequestMethod.GET)
    List<statisticResults> getAllStatisticResults()
    {
		return statisticResultsServiceImpl.getAllStatisticResults();
    }
    
   // @GetMapping
    @RequestMapping(value="/statistic/statisticResults/{statisticResultsId}",method = RequestMethod.GET)
    Optional<statisticResults> getStatisticResultsById(@PathVariable Integer statisticResultsId )
    {
		return statisticResultsServiceImpl.getOneById(statisticResultsId);
    }
    
   // @PostMapping
    @RequestMapping(value="/statistic/statisticResults",method =  RequestMethod.POST)
    statisticResults saveStatisticResults(@ModelAttribute statisticResults statisticResultsObj)
    {
    	return statisticResultsServiceImpl.saveStatisticResult(statisticResultsObj);
    }
    //@PutMapping
    @RequestMapping(value="/statistic/statisticResults",method = RequestMethod.PUT)
    statisticResults updateStatisticResults(@ModelAttribute statisticResults statisticResultsObj)
    {
    	return statisticResultsServiceImpl.saveStatisticResult(statisticResultsObj);
    }
    //@DeleteMapping
    @RequestMapping(value="/statistic/statisticResults/{statisticResultsId}", method= RequestMethod.DELETE)
    void deleteStatisticResult(@PathVariable Integer statisticResultsId)
    {
    	statisticResultsServiceImpl.deleteStatisticResults(statisticResultsId);
    }
}
