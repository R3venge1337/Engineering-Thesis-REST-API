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

import engineeringthesis.androidrestapi.account.dto.AccountDTO;
import engineeringthesis.androidrestapi.role.domain.RoleEntity;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "./test.properties")
class AccountControllerTest {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	void shouldGetAllAccounts() throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<AccountDTO>>(){});
		
		List<AccountDTO> result = objectReader.readValue(mvcResult.getResponse().getContentAsString());
		
		assertThat(result, Matchers.notNullValue());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,4})
	void shouldGetAccountById(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/" + id ))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		AccountDTO readValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AccountDTO.class);
		assertThat(readValue.toString(), Matchers.notNullValue());
		
		
		
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"admin","teacherTest"})
	void shouldGetAccountByName(String accountName) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts?accountName=" + accountName ))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		AccountDTO readValue = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), AccountDTO.class);
		
		assertThat(readValue.toString(), Matchers.notNullValue());
	}
	
	@Test
	void shouldUpdateAccount() throws Exception {
		
		MvcResult mvcResultGetAccount  = mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/1"))
				.andReturn();
		AccountDTO accountReturned = objectMapper.readValue(mvcResultGetAccount.getResponse().getContentAsString(), AccountDTO.class);
		
		accountReturned.builder().accountName("JestesKozak12").build();
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.put("/api/accounts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(accountReturned.toString())
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.notNullValue());
	}
	
	@Test
	void shouldSaveAccount() throws Exception {
		
		MvcResult mvcResultRoles  = mockMvc.perform(MockMvcRequestBuilders.get("/api/roles/1"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		RoleEntity roleReturned = objectMapper.readValue(mvcResultRoles.getResponse().getContentAsString(), RoleEntity.class);
		
		/*
		AccountDTO accountAdd = new AccountDTO();
		accountAdd.builder().accountName("admin2")
		//accountAdd.setAccountName("admin2");
		accountAdd.setAccountPassword("admin2");
		accountAdd.setAccountEmail("admin2@wp.pl");
		accountAdd.setRole(roleReturned);
		*/
		AccountDTO accountAdd = AccountDTO.builder()
				.accountName("admin2")
				.accountPassword("admin2")
				.accountEmail("admin2@wp.pl")
				.role(roleReturned)
				.build();
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.post("/api/accounts")
				.contentType(MediaType.APPLICATION_JSON)
				.content(accountAdd.toString())
				)
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.notNullValue());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {100})
	void shouldDeleteAccount(Integer id) throws Exception {
		
		MvcResult mvcResult  = mockMvc.perform(MockMvcRequestBuilders.delete("/api/accounts/"+ id))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		assertThat(mvcResult.toString(), Matchers.nullValue());
	}
}
