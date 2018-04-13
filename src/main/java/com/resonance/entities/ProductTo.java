package com.resonance.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Products")
public class ProductTo {

	@Id
	@Indexed(unique = true)
	private String modelName;
	private int price;
	private String imgSrc;
	
	public ProductTo(String modelName, int price, String imgSrc) {
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
	
	
	
}
