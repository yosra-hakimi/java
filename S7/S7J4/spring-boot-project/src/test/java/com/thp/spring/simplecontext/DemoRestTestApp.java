package com.thp.spring.simplecontext;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.thp.simplecontext.SpringBootProjectApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = SpringBootProjectApplication.class )
@AutoConfigureMockMvc
@Transactional
public class DemoRestTestApp {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {

		 mvc.perform(get("/moussaillon/1")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(content()
	                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id", is(1)));
	}
	
	@Test
	public void contextLoadfirstName() throws Exception {

		mvc.perform(get("/moussaillon")
		        .contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(content()
		                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		        .andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].firstName", is("hhh                                                                             ")));
	}
	
	

	
	
	
}