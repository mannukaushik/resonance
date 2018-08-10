package com.resonance.model.impl;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.resonance.api.annotations.SummaryProperty;
import com.resonance.model.Model;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends ResourceSupport implements Serializable,Model,Validator {
	
	private static final long serialVersionUID = 1L;
	
	@SummaryProperty
	private String modelName;
	@SummaryProperty
	private String price;
	@SummaryProperty
	private String imgSrc;
	
	public Product() {
		super();
	}

	public Product(String modelName, String price, String imgSrc) {
		super();
		this.modelName = modelName;
		this.price = price;
		this.imgSrc = imgSrc;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String generateIdFromModel() {
		return this.modelName;
	}

	public void setUpModelFromId() {
	
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}
}
