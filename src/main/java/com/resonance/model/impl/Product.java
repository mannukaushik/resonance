package com.resonance.model.impl;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.resonance.api.annotations.SummaryProperty;
import com.resonance.model.Model;

@SuppressWarnings("serial")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends ResourceSupport implements Serializable,Model {
	
	@SummaryProperty
	private String modelName;
	@SummaryProperty
	private String price;
	@SummaryProperty
	private String imgSrc;
	@SummaryProperty
	private String type;
	
	public Product() {
		super();
	}

	public Product(String modelName, String price, String imgSrc, String type) {
		super();
		this.modelName = modelName;
		this.price = price;
		this.imgSrc = imgSrc;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String generateIdFromModel() {
		return this.modelName;
	}

	public void setUpModelFromId() {
	
	}

}
