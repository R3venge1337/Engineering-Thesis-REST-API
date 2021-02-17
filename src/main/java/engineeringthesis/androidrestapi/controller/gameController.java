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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import engineeringthesis.androidrestapi.dto.GameDTO;
import engineeringthesis.androidrestapi.serviceImpl.GameServiceImpl;

@RestController
@RequestMapping(value = "/api/games")
public class GameController {
	 @Autowired
	    private GameServiceImpl gameServiceImpl;
	 
	 	@GetMapping
	  public  List<GameDTO> getAllGames()
	    {
			return gameServiceImpl.getAllGames();
	    }
	    
	    
	   @GetMapping(value = "/{gameId}")
	public  GameDTO getGameById(@PathVariable Integer gameId )
	    {
			return gameServiceImpl.getOneById(gameId);
	    }
	   
	   @GetMapping(params="gameName")
	public  GameDTO getGameByName(@RequestParam("gameName") String gameName )
		 {
				return gameServiceImpl.getOneByName(gameName);
		 }
	    
	    @PostMapping
	 public   GameDTO saveGame(@RequestBody GameDTO gameObj)
	    {
	    	return gameServiceImpl.saveGame(gameObj);
	    }
	    
	    @PutMapping(value = "/{gameId}")
	 public   void updateGame(@PathVariable Integer gameId,
	    				@RequestBody GameDTO gameObj)
	    {
	    	gameServiceImpl.updateGame(gameId, gameObj);
	    }
	    
	    @DeleteMapping(value = "/{gameId}")
	  public  void deleteGame(@PathVariable Integer gameId)
	    {
	    	gameServiceImpl.deleteGame(gameId);
	    }
}
