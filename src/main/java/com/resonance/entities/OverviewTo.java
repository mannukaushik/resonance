package com.resonance.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.resonance.mongo.generic.MongoEntity;

@Document(collection = "Overview")
public class OverviewTo implements MongoEntity{

	
	@Id
	@Indexed
	private String modelName;
	private String descriptionHeader;
	private String description;
	private String imgSrc;
	
	public OverviewTo() {
		super();
	}
	
	public OverviewTo(String modelName) {
		super();
		this.modelName = modelName;
	}
	
	public OverviewTo(String modelName, String descriptionHeader, String description, String imgSrc) {
		super();
		this.modelName = modelName;
		this.descriptionHeader = descriptionHeader;
		this.description = description;
		this.imgSrc = imgSrc;
	}
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getDescriptionHeader() {
		return descriptionHeader;
	}
	public void setDescriptionHeader(String descriptionHeader) {
		this.descriptionHeader = descriptionHeader;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
}
