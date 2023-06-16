package ar.com.codoacodo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
class TurnosApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/resource"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers
						.content()
						.contentType(MediaType.APPLICATION_JSON)
				);
				
	}

}
