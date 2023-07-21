package engineeringthesis.androidrestapi.controllerTest;

/*
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "./test.properties")
public class CategoryControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void shouldGetAllCategories() throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CategoryDto>>(){});
		
		List<CategoryDto> result = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(result, Matchers.notNullValue());
	}

	@ParameterizedTest
	void shouldGetAllCategoriesByLanguage(String langName) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/languages/" + langName )
				.param(langName, "\"Angielski\",\"Koreański\"")
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CategoryDto>>(){});
		
		List<CategoryDto> readValue = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"","Zwierzęta","Sport"})
	void shouldGetCategoriesByName(String categoryName) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories?categoryName=" + categoryName))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<CategoryDto>(){});
		
		CategoryDto readValue = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@Test
	void shouldUpdateCategory() throws Exception {
		
		MvcResult mvcResultGetAccount  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/1"))
				.andReturn();
		
		CategoryDto categoryReturned = objectMapper.readValue(mvcResultGetAccount.getResponse().getContentAsString(), CategoryDto.class);
		
		categoryReturned.setAccepted(true);
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.put("/api/categories/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(categoryReturned.toString())
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
	@ValueSource(ints = {2})
	void shouldDeleteCategory(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.delete("/api/categories/"+ id))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.nullValue());
	}


}
 */
