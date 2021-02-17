package engineeringthesis.androidrestapi.controllerTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "./test.properties")
public class LoginControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	void shouldLoginAndCreateToken() throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.post("/api/authenticate")
				.contentType(MediaType.APPLICATION_JSON)
				.param("username", "admin")
	            .param("password", "admin123!Z")  
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
}
