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

import engineeringthesis.androidrestapi.category.CategoryTeacherDTO;

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
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CategoryTeacherDTO>>(){});
		
		List<CategoryTeacherDTO> result = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(result, Matchers.notNullValue());
	}

	@Test
	void shouldSaveCategoryTeacher() throws Exception {
		
		CategoryTeacherDTO categoryTeacher = new CategoryTeacherDTO();
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
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<CategoryTeacherDTO>>(){});
		
		List<CategoryTeacherDTO> readValue = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
}
