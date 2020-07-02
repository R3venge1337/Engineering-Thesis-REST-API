package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.gameMatch;
import engineeringthesis.androidrestapi.serviceImpl.gameMatchServiceImpl;

@RestController
public class gameMatchController {
	
	@Autowired
    private gameMatchServiceImpl gameMatchServiceImpl;
	
	//@GetMapping
    @RequestMapping(value="/game/matches",method = RequestMethod.GET)
    List<gameMatch> getAllGameMatches()
    {
		return gameMatchServiceImpl.getAllGameMatch();
    }
    
   // @GetMapping
    @RequestMapping(value="/game/match/{id}",method = RequestMethod.GET)
    Optional<gameMatch> getGameMatchById(@PathVariable Integer gameMatchId )
    {
		return gameMatchServiceImpl.getOneById(gameMatchId);
    }
    
   // @PostMapping
    @RequestMapping(value="/game/match",method =  RequestMethod.POST)
    gameMatch saveGameMatch(@ModelAttribute gameMatch gameMatchObj)
    {
    	return gameMatchServiceImpl.saveGameMatch(gameMatchObj);
    }
    //@PutMapping
    @RequestMapping(value="/game/match",method = RequestMethod.PUT)
    gameMatch updateGameMatch (@ModelAttribute gameMatch gameMatchObj)
    {
    	return gameMatchServiceImpl.saveGameMatch(gameMatchObj);
    }
    //@DeleteMapping
    @RequestMapping(value="/game/match/{id}",method= RequestMethod.DELETE)
    void deleteGameMatchById(@PathVariable Integer gameMatchId)
    {
    	gameMatchServiceImpl.deleteGameMatch(gameMatchId);
    }
}
