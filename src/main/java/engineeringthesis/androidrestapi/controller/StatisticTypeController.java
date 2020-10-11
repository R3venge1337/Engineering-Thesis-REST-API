package engineeringthesis.androidrestapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.dto.StatisticTypeDTO;
import engineeringthesis.androidrestapi.serviceImpl.StatisticTypeServiceImpl;

@RestController
@RequestMapping(value = "/api/statistics")
public class StatisticTypeController {
	
	@Autowired
	StatisticTypeServiceImpl statisticServiceImpl;
	
	@GetMapping
    List<StatisticTypeDTO> getAllStatisticsTypes()
    {
		return statisticServiceImpl.getAllStatistic();
    }
    
    @GetMapping(value = "/{statisticId}")
    StatisticTypeDTO getStatisticTypeById(@PathVariable Integer statisticId )
    {
		return statisticServiceImpl.getOneById(statisticId);
    }
    
    @PostMapping
    StatisticTypeDTO saveStatistic(@RequestBody StatisticTypeDTO statisticTypeObj)
    {
    	return statisticServiceImpl.saveStatisticType(statisticTypeObj);
    }
    
    @PutMapping(value = "/{statisticId}" )
    StatisticTypeDTO updateStatistic(@RequestBody StatisticTypeDTO statisticTypeObj,
    		 					  @PathVariable Integer statisticId)
    {
    	return statisticServiceImpl.updateStatisticType(statisticId,statisticTypeObj);
    }
    
    @DeleteMapping(value = "/{statisticId}" )
    void deleteStatisticById(@PathVariable Integer statisticId)
    {
    	statisticServiceImpl.deleteStatistic(statisticId);
    }
	
	
}
