package engineeringthesis.androidrestapi.controllerTest;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
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
import engineeringthesis.androidrestapi.dto.LanguageDTO;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "./test.properties")
public class LanguageControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	void shouldGetAllLanguages() throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/languages"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<LanguageDTO>>(){});
		
		List<LanguageDTO> result = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(result, Matchers.notNullValue());
	}

	@ParameterizedTest
	@ValueSource(ints = {1})
	void shouldGetLanguageById(Integer languageId) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/languages/" + languageId ))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<LanguageDTO>(){});
		
		LanguageDTO readValue = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Angielski","Koreanski"})
	void shouldGetLanguageByName(String languageName) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/languages?languageName=" + languageName))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<LanguageDTO>(){});
		
		LanguageDTO readValue = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@Test
	void shouldUpdateLanguage() throws Exception {
		
		MvcResult mvcResultGetLanguage  = mockMvc.perform(MockMvcRequestBuilders.get("/api/languages/1"))
				.andReturn();
		
		LanguageDTO languageReturned = objectMapper.readValue(mvcResultGetLanguage.getResponse().getContentAsString(), LanguageDTO.class);
		
		languageReturned.setAccepted(true);
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.put("/api/languages/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(languageReturned.toString())
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.notNullValue());
	}
	
	
	@Test
	void shouldSaveLanguage() throws Exception {
		
		LanguageDTO languageReturned = new LanguageDTO();
		languageReturned.setLanguageId(0);
		languageReturned.setLanguageName("Turecki");
		languageReturned.setLanguageCreatedDate(LocalDateTime.now());
		languageReturned.setNew(false);
		languageReturned.setAccepted(false);
		
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.post("/api/languages")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.content(languageReturned.toString())
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.notNullValue());
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {1})
	void shouldDeleteCategory(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.delete("/api/languages/"+ id))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.nullValue());
	}
}
