package com.resonance.tests.configuration;

import org.mockito.Mockito;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.resonance.api.elements.JacksonUtils;
import com.resonance.helper.generic.ProductHelper;
import com.resonance.service.processor.impl.ProductServiceProcessor;

public class AppTest{
	@Bean(name= "productServiceProcessor")
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ProductServiceProcessor productServiceProcessor() {
		return new ProductServiceProcessor();
	}
	@Bean(name= "overviewServiceProcessor")
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ProductServiceProcessor overviewServiceProcessor() {
		return new ProductServiceProcessor();
	}
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JacksonUtils jacksonUtils() {
		return Mockito.mock(JacksonUtils.class);
	}
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ProductHelper productHelper() {
		return Mockito.mock(ProductHelper.class);
	}
}
