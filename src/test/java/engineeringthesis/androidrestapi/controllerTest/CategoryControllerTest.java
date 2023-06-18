package engineeringthesis.androidrestapi.controllerTest;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import engineeringthesis.androidrestapi.category.dto.CategoryDTO;

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
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CategoryDTO>>(){});
		
		List<CategoryDTO> result = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(result, Matchers.notNullValue());
	}

	@ParameterizedTest
	void shouldGetAllCategoriesByLanguage(String langName) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/languages/" + langName )
				.param(langName, "\"Angielski\",\"Koreański\"")
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CategoryDTO>>(){});
		
		List<CategoryDTO> readValue = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"","Zwierzęta","Sport"})
	void shouldGetCategoriesByName(String categoryName) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories?categoryName=" + categoryName))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<CategoryDTO>(){});
		
		CategoryDTO readValue = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@Test
	void shouldUpdateCategory() throws Exception {
		
		MvcResult mvcResultGetAccount  = mockMvc.perform(MockMvcRequestBuilders.get("/api/categories/1"))
				.andReturn();
		
		CategoryDTO categoryReturned = objectMapper.readValue(mvcResultGetAccount.getResponse().getContentAsString(),CategoryDTO.class);
		
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
	*/
	
	@ParameterizedTest
	@ValueSource(ints = {2})
	void shouldDeleteCategory(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.delete("/api/categories/"+ id))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.nullValue());
	}
}
