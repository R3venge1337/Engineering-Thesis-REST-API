package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.gameMatchResults;
import engineeringthesis.androidrestapi.serviceImpl.gameMatchResultsServiceImpl;

@RestController
public class gameMatchResultsController {
	@Autowired
    private gameMatchResultsServiceImpl gameMatchResultsServiceImpl;
	
	//@GetMapping
    @RequestMapping(value="/game/match/results",method = RequestMethod.GET)
    List<gameMatchResults> getAllGameMatchResults()
    {
		return gameMatchResultsServiceImpl.getAllgameMatchResults();
    }
    
   // @GetMapping
    @RequestMapping(value="/game/match/result/{gameMatchResultsId}",method = RequestMethod.GET)
    Optional<gameMatchResults> getGameMatchResultById(@PathVariable Integer gameMatchResultsId )
    {
		return gameMatchResultsServiceImpl.getOneById(gameMatchResultsId);
    }
    
   // @PostMapping
    @RequestMapping(value="/game/match/result",method =  RequestMethod.POST)
    gameMatchResults saveGameMatch(@ModelAttribute gameMatchResults gameMatchResultsObj)
    {
    	return gameMatchResultsServiceImpl.savegameMatchResults(gameMatchResultsObj);
    }
    //@PutMapping
    @RequestMapping(value="/game/match/result",method = RequestMethod.PUT)
    gameMatchResults updateGameMatchResults (@ModelAttribute gameMatchResults gameMatchResultsObj)
    {
    	return gameMatchResultsServiceImpl.savegameMatchResults(gameMatchResultsObj);
    }
    //@DeleteMapping
    @RequestMapping(value="/game/match/result/{gameMatchResultsId}",method= RequestMethod.DELETE)
    void deleteGameMatchResultsById(@PathVariable Integer gameMatchResultsId)
    {
    	gameMatchResultsServiceImpl.deleteGameMatchResults(gameMatchResultsId);
    }
}
