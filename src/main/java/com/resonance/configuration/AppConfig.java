package com.resonance.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.resonance.api.elements.JacksonUtils;
import com.resonance.helper.generic.ProductHelper;
import com.resonance.service.processor.impl.ProductServiceProcessor;

@Configuration
@EnableSpringDataWebSupport
@EnableAutoConfiguration
@EnableHypermediaSupport(type = {HypermediaType.HAL})
public class AppConfig implements WebMvcConfigurer{

	@Bean(name= "productServiceProcessor")
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ProductServiceProcessor productServiceProcessor() {
		return new ProductServiceProcessor();
	}
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JacksonUtils jacksonUtils() {
		return new JacksonUtils();
	}
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ProductHelper productHelper() {
		return new ProductHelper();
	}
}
