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
	private String description;
	private String bluetooth;
	private String subWoofer;
	private String blueRay;
	private String dvdPlayback;
	private String power;
	
	public OverviewTo() {
		super();
	}
	
	public OverviewTo(String modelName) {
		super();
		this.modelName = modelName;
	}
	
	
	public OverviewTo(String modelName, String description, String bluetooth, String subWoofer, String blueRay,
			String dvdPlayback, String power) {
		super();
		this.modelName = modelName;
		this.description = description;
		this.bluetooth = bluetooth;
		this.subWoofer = subWoofer;
		this.blueRay = blueRay;
		this.dvdPlayback = dvdPlayback;
		this.power = power;
	}

	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(String bluetooth) {
		this.bluetooth = bluetooth;
	}

	public String getSubWoofer() {
		return subWoofer;
	}

	public void setSubWoofer(String subWoofer) {
		this.subWoofer = subWoofer;
	}

	public String getBlueRay() {
		return blueRay;
	}

	public void setBlueRay(String blueRay) {
		this.blueRay = blueRay;
	}

	public String getDvdPlayback() {
		return dvdPlayback;
	}

	public void setDvdPlayback(String dvdPlayback) {
		this.dvdPlayback = dvdPlayback;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
}
