package engineeringthesis.androidrestapi;



import static org.hamcrest.MatcherAssert.assertThat;
import java.util.LinkedList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import engineeringthesis.androidrestapi.game.GameDTO;
import engineeringthesis.androidrestapi.game.GameEntity;
import engineeringthesis.androidrestapi.game.GameMapper;
import engineeringthesis.androidrestapi.game.GameRepository;
import engineeringthesis.androidrestapi.game.GameServiceImpl;


@SpringBootTest
@AutoConfigureMockMvc
public class GameTest {
	
	
	@Mock
	private GameRepository gameRepository;
	
	@Mock
	private GameMapper mapper;

	List<GameEntity> listwords;
	List<GameDTO> listwordsDTO;
	
	@InjectMocks
	private GameServiceImpl gameServiceImpl;
	
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		//gameServiceImpl = new GameServiceImpl(gameRepository,mapper);
		
		listwords = new LinkedList<GameEntity>();
		listwords.add(new GameEntity(1,"Find out pciture"));
		listwords.add(new GameEntity(2,"Find out Vocabualry"));
		listwords.add(new GameEntity(3,"Drag and Drop"));
		listwords.add(new GameEntity(4,"Select And Adjust"));
		listwords.add(new GameEntity(5,"Memory game"));
		
		listwordsDTO = new LinkedList<GameDTO>();
		listwordsDTO.add(new GameDTO(1,"Find out pciture"));
		listwordsDTO.add(new GameDTO(2,"Find out Vocabualry"));
		listwordsDTO.add(new GameDTO(3,"Drag and Drop"));
		listwordsDTO.add(new GameDTO(4,"Select And Adjust"));
		listwordsDTO.add(new GameDTO(5,"Memory game"));
		
	}

	
	@Test
	public void getGamesTest()
	{
		//given
		//when
		Mockito.when(gameServiceImpl.getAllGames()).thenReturn(listwordsDTO);
		//then
		assertThat(listwordsDTO,Matchers.hasSize(5));
	}
	
	@Test
	public void getGameByName()
	{
		//given
		String gameName = "Drag and Drop";
		GameDTO game = new GameDTO(3,"Drag and Drop");
		//when
		Mockito.when(gameServiceImpl.getOneByName(gameName)).thenReturn(game);
		//then
	}
	
	@Test
	public void saveGame()
	{
		//given
		GameDTO gameAdded = new GameDTO(6,"Visualizator Words");
		//when
		Mockito.when(gameServiceImpl.saveGame(gameAdded)).thenReturn(gameAdded);
		listwordsDTO.add(gameAdded);
		//then
		assertThat(listwordsDTO,Matchers.hasSize(6));
	}
	
	@Test
	public void deleteGame()
	{
		//given
		GameDTO gameDelete = new GameDTO(6,"Visualizator Words");
		//when
		//Mockito.when(gameServiceImpl.deleteGame(6));
		listwordsDTO.remove(gameDelete);
		//then
		assertThat(listwordsDTO,Matchers.hasSize(5));
	}
	
	
	
	
}
