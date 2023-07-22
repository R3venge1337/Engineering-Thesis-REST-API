package engineeringthesis.androidrestapi.game.domain;


/*
@SpringBootTest
@AutoConfigureMockMvc
public class GameTest {
	

	@Mock
	private GameRepository gameRepository;

	List<Game> listwords;
	List<GameDto> listwordsDTO;
	
	@InjectMocks
	private GameFacade gameFacade;
	
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		//gameServiceImpl = new GameServiceImpl(gameRepository,mapper);
		Game game1 = new Game();
		game1.setGameName("Find out pciture");
		Game game2 = new Game();
		game2.setGameName("Find out Vocabualry");
		Game game3 = new Game();
		game3.setGameName("Drag and Drop");
		Game game4 = new Game();
		game4.setGameName("Select And Adjust");
		Game game5 = new Game();
		game5.setGameName("Memory game");

		listwords = new LinkedList<Game>();
		listwords.add(game1);
		listwords.add(game2);
		listwords.add(game3);
		listwords.add(game4);
		listwords.add(game5);
		
		listwordsDTO = new LinkedList<GameDto>();
		listwordsDTO.add(new GameDto("Find out pciture"));
		listwordsDTO.add(new GameDto("Find out Vocabualry"));
		listwordsDTO.add(new GameDto("Drag and Drop"));
		listwordsDTO.add(new GameDto("Select And Adjust"));
		listwordsDTO.add(new GameDto("Memory game"));
		
	}

	
	@Test
	public void getGamesTest()
	{
		//given
		//when
		Mockito.when(gameFacade.getAllGames()).thenReturn(listwordsDTO);
		//then
		assertThat(listwordsDTO,Matchers.hasSize(5));
	}
	
	@Test
	public void getGameByName()
	{
		//given
		String gameName = "Drag and Drop";
		GameDto game = new GameDto(3,"Drag and Drop");
		//when
		Mockito.when(gameFacade.(gameName)).thenReturn(game);
		//then
	}
	
	@Test
	public void saveGame()
	{
		//given
		GameDto gameAdded = new GameDto(6,"Visualizator Words");
		//when
		Mockito.when(gameFacade.saveGame(gameAdded)).thenReturn(gameAdded);
		listwordsDTO.add(gameAdded);
		//then
		assertThat(listwordsDTO,Matchers.hasSize(6));
	}
	
	@Test
	public void deleteGame()
	{
		//given
		GameDto gameDelete = new GameDto(6,"Visualizator Words");
		//when
		//Mockito.when(gameServiceImpl.deleteGame(6));
		listwordsDTO.remove(gameDelete);
		//then
		assertThat(listwordsDTO,Matchers.hasSize(5));
	}


}
 */