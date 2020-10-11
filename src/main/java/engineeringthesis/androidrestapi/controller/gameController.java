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
import engineeringthesis.androidrestapi.dto.GameDTO;
import engineeringthesis.androidrestapi.serviceImpl.GameServiceImpl;

@RestController
@RequestMapping(value = "/api/games")
public class GameController {
	 @Autowired
	    private GameServiceImpl gameServiceImpl;
	 
	 	@GetMapping
	    List<GameDTO> getAllGames()
	    {
			return gameServiceImpl.getAllGames();
	    }
	    
	    
	   @GetMapping(value = "/{gameId}")
	  GameDTO getGameById(@PathVariable Integer gameId )
	    {
			return gameServiceImpl.getOneById(gameId);
	    }
	    
	    @PostMapping
	    GameDTO saveGame(@RequestBody GameDTO gameObj)
	    {
	    	return gameServiceImpl.saveGame(gameObj);
	    }
	    
	    @PutMapping(value = "/{gameId}")
	    void updateGame(@PathVariable Integer gameId,
	    				@RequestBody GameDTO gameObj)
	    {
	    	gameServiceImpl.updateGame(gameId, gameObj);
	    }
	    
	    @DeleteMapping(value = "/{gameId}")
	    void deleteGame(@PathVariable Integer gameId)
	    {
	    	gameServiceImpl.deleteGame(gameId);
	    }
}
