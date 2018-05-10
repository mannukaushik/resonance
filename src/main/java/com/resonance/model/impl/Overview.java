package com.resonance.model.impl;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.resonance.api.annotations.SummaryProperty;
import com.resonance.model.Model;

public class Overview extends ResourceSupport implements Serializable,Model {

	private static final long serialVersionUID = 1L;
	
	@SummaryProperty
	private String modelName;
	@SummaryProperty
	private String descriptionHeader;
	@SummaryProperty
	private String description;
	@SummaryProperty
	private String imgSrc;
	
	public Overview() {
		super();
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

	public String generateIdFromModel() {
		return this.modelName;
	}

	public void setUpModelFromId() {
		
	}

}
