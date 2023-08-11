package com.testZara.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.testZara.request.PriceRequest;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EndpointTest {
	private static final Logger log = LoggerFactory.getLogger(EndpointTest.class);

	@Autowired
    private MockMvc mvc;
	
	@Test
	public void mvcTest() {
		log.info("prueba1");
		assertThat(mvc).isNotNull();
	}
	
	@Test
	public void endopointTest1() throws Exception{
		LocalDateTime time1 = LocalDateTime.of(2020,06, 14,10,0); 		
		mvc.perform( MockMvcRequestBuilders
			      .post("/getPrice")
			      .content(asJsonString(new PriceRequest(time1, 35455, 1)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
	}

	@Test
	public void endopointTest2() throws Exception{
		LocalDateTime time2 = LocalDateTime.of(2020,06, 14,16,0);
		
		mvc.perform( MockMvcRequestBuilders
			      .post("/getPrice")
			      .content(asJsonString(new PriceRequest(time2, 35455, 1)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("25.45"));
	}

	
	@Test
	public void endopointTest3() throws Exception{
		
		LocalDateTime time3 = LocalDateTime.of(2020,06, 14,21,0);
		
		mvc.perform( MockMvcRequestBuilders
			      .post("/getPrice")
			      .content(asJsonString(new PriceRequest(time3, 35455, 1)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"));
	}

	
	@Test
	public void endopointTest4() throws Exception{
		
		LocalDateTime time4 = LocalDateTime.of(2020,06, 15,10,0);
		
		mvc.perform( MockMvcRequestBuilders
			      .post("/getPrice")
			      .content(asJsonString(new PriceRequest(time4, 35455, 1)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("30.5"));
	}

	
	@Test
	public void endopointTest5() throws Exception{
		LocalDateTime time5 = LocalDateTime.of(2020,06, 16,21,0);
		
		mvc.perform( MockMvcRequestBuilders
			      .post("/getPrice")
			      .content(asJsonString(new PriceRequest(time5, 35455, 1)))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(MockMvcResultMatchers.jsonPath("$.price").value("38.95"));
	}	
	
	public static String asJsonString(final Object obj) {
	    try {
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	objectMapper.registerModule(new JavaTimeModule());
	        return objectMapper.writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
