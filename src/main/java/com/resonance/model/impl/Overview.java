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
	private String description;
	@SummaryProperty
	private String bluetooth;
	@SummaryProperty
	private String subWoofer;
	@SummaryProperty
	private String blueRay;
	@SummaryProperty
	private String dvdPlayback;
	@SummaryProperty
	private String power;
	
	public Overview() {
		super();
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

	public String generateIdFromModel() {
		return this.modelName;
	}

	public void setUpModelFromId() {
		
	}

}
