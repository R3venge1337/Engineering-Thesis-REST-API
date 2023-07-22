package engineeringthesis.androidrestapi.controllerTest;

/*
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "./test.properties")
public class AudioControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void shouldGetAllAudio() throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/audio"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<AudioDto>>(){});
		
		List<AudioDto> result = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(result, Matchers.notNullValue());
	}
	

	@ParameterizedTest
	@ValueSource( ints = {1,2,4})
	void shouldGetAudioById(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/audio/" + id ))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		AudioDto readValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AudioDto.class);
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"","dog.m4a","archery.m4a"})
	void shouldGetAudioByName(String audioName) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/audio?audioFileName=" + audioName)
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		AudioDto readValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AudioDto.class);
		
		if(readValue == null)
		{
			assertThat(readValue.toString(), Matchers.nullValue());
		}
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@Test
	void shouldUpdateAudio() throws Exception {
		
		MvcResult mvcResultGetAccount  = mockMvc.perform(MockMvcRequestBuilders.get("/api/audio/1"))
				.andReturn();
		
		AudioDto audioReturned = objectMapper.readValue(mvcResultGetAccount.getResponse().getContentAsString(), AudioDto.class);
		
		audioReturned.setAccepted(true);
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.put("/api/audio")
				.contentType(MediaType.APPLICATION_JSON)
				.content(audioReturned.toString())
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.notNullValue());
	}
	
	/*
	@Test
	void shouldSaveAudio() throws Exception {
		
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.post("/api/audio/")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.content()
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.notNullValue());
	}

	
	@ParameterizedTest
	@ValueSource(ints = {20})
	void shouldDeleteAudio(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.delete("/api/audio/"+ id))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.nullValue());
	}
	
	
}
*/