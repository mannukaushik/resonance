package com.resonance.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.resonance.mongo.generic.MongoEntity;


@Document(collection = "Products")
public class ProductTo implements MongoEntity{

	@Id
	@Indexed
	private String modelName;
	private String price;
	private String imgSrc;	
	
	public ProductTo() {
		super();
	}
	
	


	public ProductTo(String modelName) {
		super();
		this.modelName = modelName;
	}

	public ProductTo(String modelName, String price, String imgSrc) {
		super();
		this.modelName = modelName;
		this.price = price;
		this.imgSrc = imgSrc;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getImgSrc() {
		return imgSrc;
	}


	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

}
