package engineeringthesis.androidrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import engineeringthesis.androidrestapi.model.game;
import engineeringthesis.androidrestapi.serviceImpl.gameServiceImpl;

@RestController
public class gameController {
	 @Autowired
	    private gameServiceImpl gameServiceImpl;
	 
	//@GetMapping
	    @RequestMapping(value="/games",method = RequestMethod.GET)
	    List<game> getAllGames()
	    {
			return gameServiceImpl.getAllGames();
	    }
	    
	    
	   // @GetMapping
	    @RequestMapping(value="/game/{gameId}",method = RequestMethod.GET)
	    Optional<game> getGameById(@PathVariable Integer gameId )
	    {
			return gameServiceImpl.getOneById(gameId);
	    }
	    
	   // @PostMapping
	    @RequestMapping(value="/game",method =  RequestMethod.POST)
	    game saveGame(@ModelAttribute game gameObj)
	    {
	    	return gameServiceImpl.saveGame(gameObj);
	    }
	    //@PutMapping
	    @RequestMapping(value="/game",method = RequestMethod.PUT)
	    game updateGame(@ModelAttribute game gameObj)
	    {
	    	return gameServiceImpl.saveGame(gameObj);
	    }
	    //@DeleteMapping
	    @RequestMapping(value="/game/{gameId}",method= RequestMethod.DELETE)
	    void deleteGame(@PathVariable Integer gameId)
	    {
	    	gameServiceImpl.deleteGame(gameId);
	    }
}
