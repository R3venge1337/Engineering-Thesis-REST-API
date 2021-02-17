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
import engineeringthesis.androidrestapi.dto.AudioDTO;


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
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<AudioDTO>>(){});
		
		List<AudioDTO> result = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(result, Matchers.notNullValue());
	}
	
	@Test
	@ParameterizedTest
	@ValueSource( ints = {1,2,4})
	void shouldGetAudioById(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/audio/" + id ))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		AudioDTO readValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AudioDTO.class);
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@ParameterizedTest
	@ValueSource( strings = {"","dog.m4a","archery.m4a"})
	void shouldGetAudioByName(String audioName) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/audio?audioFileName=" + audioName)
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		AudioDTO readValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AudioDTO.class);
		
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
		
		AudioDTO audioReturned = objectMapper.readValue(mvcResultGetAccount.getResponse().getContentAsString(), AudioDTO.class);
		
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
	*/
	
	@Test
	@ParameterizedTest
	@ValueSource(ints = {20})
	void shouldDeleteAudio(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.delete("/api/audio/"+ id))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.nullValue());
	}
	
	
}
