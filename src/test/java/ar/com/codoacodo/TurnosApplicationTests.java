package ar.com.codoacodo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = TurnosApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-test.properties")
class TurnosApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/resource"))
				.andExpect(status().is(403))
				/*.andExpect(MockMvcResultMatchers
						.content()
						.contentType(MediaType.APPLICATION_JSON)
				)*/;
				
	}

	@Test
	void when_() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/resource"))
				.andExpect(status().is(403))
				/*.andExpect(MockMvcResultMatchers
						.content()
						.contentType(MediaType.APPLICATION_JSON)
				)*/;
				
	}
}
