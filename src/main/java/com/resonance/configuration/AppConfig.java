package com.resonance.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.resonance.service.processor.impl.ProductServiceProcessor;

@Configuration
@EnableSpringDataWebSupport
@EnableWebMvc
@EnableHypermediaSupport(type = {HypermediaType.HAL})
@ComponentScan(basePackages= {"com.resonance.controllers", "com.resonance.data.configuration", "com.resonance.service.processor.impl"})
public class AppConfig implements WebMvcConfigurer{

	@Bean(name= "productServiceProcessor")
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ProductServiceProcessor productServiceProcessor() {
		return new ProductServiceProcessor();
	}
}
