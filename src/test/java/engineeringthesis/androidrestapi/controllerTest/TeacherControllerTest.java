package engineeringthesis.androidrestapi.controllerTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "./test.properties")
public class TeacherControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
}
