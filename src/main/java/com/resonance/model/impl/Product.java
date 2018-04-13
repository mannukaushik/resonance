package com.resonance.model.impl;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.resonance.model.Model;

public class Product extends ResourceSupport implements Serializable,Model {
	
	private static final long serialVersionUID = 1L;
	
	private String modelName;
	private int price;
	private String imgSrc;
		
	public Product() {
		super();
	}

	public Product(String modelName, int price, String imgSrc) {
		super();
		this.modelName = modelName;
		this.price = price;
		this.imgSrc = imgSrc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String generateIdFromModel() {
		return null;
	}

	public void setUpModelFromId() {
	
	}
}
