package com.resonance.api.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.resonance.controllers.impl.ProductController;
import com.resonance.model.impl.Product;
import com.resonance.service.processor.ServiceProcessor;
import com.resonance.tests.configuration.AppTest;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {AppTest.class})
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	@InjectMocks
	private ProductController productController;

	private MockMvc mockMvc;

	@Mock
	private ServiceProcessor<Product> productServiceProcessor;
	
	Product product = new Product();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		product.setImgSrc("C:/Users/images");
		product.setPrice("8000");
		product.setModelName("Maharaja");
	}
	
	@Test
	public void testGetData() throws Exception {
		mockMvc.perform(get("/products/Maharaja",1L)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("modelName",is("Maharaja")));
	}
	@Test
	public void testPostData() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		 mockMvc.perform(post("/products").content(mapper.writeValueAsString(product)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("modelName",is("Maharaja")))
		.andExpect(jsonPath("imgSrc",is("C:/Users/images")))
		.andExpect(jsonPath("price",is("8000")));
		
		
	}
	@Test
	public void testDeleteData() throws Exception {
		mockMvc.perform(delete("/products/Maharaja",1L)).andExpect(status().isNoContent())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
}
