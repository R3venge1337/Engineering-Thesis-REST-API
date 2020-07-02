package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.statistic;
import engineeringthesis.androidrestapi.serviceImpl.statisticServiceImpl;

@RestController
public class statisticController {
	
	@Autowired
	statisticServiceImpl statisticServiceImpl;
	
	  //@GetMapping
    @RequestMapping(value = {"/statistics"}, method = RequestMethod.GET)
    List<statistic> getAllStatistics()
    {
		return statisticServiceImpl.getAllStatistic();
    }
    
    //@GetMapping
    @RequestMapping(value="/statistic/{statisticId}",method = RequestMethod.GET)
    Optional<statistic> getStatisticById(@PathVariable Integer statisticId )
    {
		return statisticServiceImpl.getOneById(statisticId);
    }
    //@PostMapping
    @RequestMapping(value="/statistic",method = RequestMethod.POST)
    statistic saveStatistic(@ModelAttribute statistic statisticObj)
    {
    	return statisticServiceImpl.saveStatisticResult(statisticObj);
    }
    @PutMapping
    @RequestMapping(value="/statistic",method = RequestMethod.PUT)
    statistic updateStatistic(@ModelAttribute statistic statisticObj)
    {
    	return statisticServiceImpl.saveStatisticResult(statisticObj);
    }
    @DeleteMapping
    @RequestMapping(value="/statistic/{statisticId}",method= RequestMethod.DELETE)
    void deleteStatisticById(@PathVariable Integer statisticId)
    {
    	statisticServiceImpl.deleteStatistic(statisticId);
    }
	
	
}
