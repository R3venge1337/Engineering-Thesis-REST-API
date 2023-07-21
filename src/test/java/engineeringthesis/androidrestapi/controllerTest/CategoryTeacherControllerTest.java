package engineeringthesis.androidrestapi.controllerTest;

/*
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "./test.properties")
public class CategoryTeacherControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@ParameterizedTest
	@ValueSource(ints = {2})
	void shouldGetAllCategoriesTeacher(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/teachers/"+ id))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CategoryTeacherDto>>(){});
		
		List<CategoryTeacherDto> result = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(result, Matchers.notNullValue());
	}

	@Test
	void shouldSaveCategoryTeacher() throws Exception {
		
		CategoryTeacherDto categoryTeacher = new CategoryTeacherDto();
		categoryTeacher.setTeacherId(null);
		categoryTeacher.setCategoryTeacherId(null);
		categoryTeacher.setCategoryId(null);
		categoryTeacher.setNew(false);
		categoryTeacher.setAccepted(false);
		
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/teachers")
				.contentType(MediaType.APPLICATION_JSON)
				.content(categoryTeacher.toString())
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CategoryTeacherDto>>(){});
		
		List<CategoryTeacherDto> readValue = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
}
 */
