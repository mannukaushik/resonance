package com.resonance.api.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resonance.controllers.impl.OverviewController;
import com.resonance.model.impl.Overview;
import com.resonance.service.processor.ServiceProcessor;
import com.resonance.tests.configuration.AppTest;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {AppTest.class})
@WebMvcTest(OverviewController.class)
public class OverviewControllerTest {

	@InjectMocks
	private OverviewController overviewController;
	private MockMvc mockMvc;
	
	@Mock
	private ServiceProcessor<Overview> overvServiceProcessor;
	Overview overview = new Overview();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(overviewController).build();
		overview.setImgSrc("C:/Users/images");
		overview.setDescriptionHeader("Dynamic lighting for dancing to the beat");
		overview.setModelName("Maharaja");
		overview.setDescription("Step in time to the dazzling beat of music.");
	}
	@Test
	public void testPostData() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		 mockMvc.perform(post("/overview").content(mapper.writeValueAsString(overview)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("modelName",is("Maharaja")))
		.andExpect(jsonPath("imgSrc",is("C:/Users/images")))
		.andExpect(jsonPath("descriptionHeader",is("Dynamic lighting for dancing to the beat")))
		.andExpect(jsonPath("description",is("Step in time to the dazzling beat of music.")));
		
		
	}
}
