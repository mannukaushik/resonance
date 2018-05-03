package com.resonance.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.resonance.mongo.generic.MongoEntity;

@Document(collection = "Specifications")
public class SpecTo implements MongoEntity{
	
	@Id
	@Indexed
	private String modelName;
	private String playbackMedia;
	private String antenna;
	private int stationPresets;
	private String tunerBands;
	private int packagingHeight;
	private int packagingWidth;
	private int packagingDepth;
	private int powerSupply;
	private int numberOfSpeakers;
	private String loudspeakerEnhancement;
	private String speakerTypes;
	private String soundPower;
	private int headphone;
	private String microPhone;
	private String usb;
	private String mp3Link;
	private int rmtctrl;
	private int userManual;
	private String warranty;
	
	public SpecTo() {
		super();
	}
	
	public SpecTo(String modelName) {
		super();
		this.modelName = modelName;
	}
	
	public SpecTo(String modelName, String playbackMedia, String antenna, int stationPresets, String tunerBands, int packagingHeight,
			int packagingWidth, int packagingDepth, int powerSupply, int numberOfSpeakers,
			String loudspeakerEnhancement, String speakerTypes, String soundPower, int headphone, String microPhone,
			String usb, String mp3Link, int rmtctrl, int userManual, String warranty) {
		super();
		this.modelName = modelName;
		this.playbackMedia = playbackMedia;
		this.antenna = antenna;
		this.stationPresets = stationPresets;
		this.tunerBands = tunerBands;
		this.packagingHeight = packagingHeight;
		this.packagingWidth = packagingWidth;
		this.packagingDepth = packagingDepth;
		this.powerSupply = powerSupply;
		this.numberOfSpeakers = numberOfSpeakers;
		this.loudspeakerEnhancement = loudspeakerEnhancement;
		this.speakerTypes = speakerTypes;
		this.soundPower = soundPower;
		this.headphone = headphone;
		this.microPhone = microPhone;
		this.usb = usb;
		this.mp3Link = mp3Link;
		this.rmtctrl = rmtctrl;
		this.userManual = userManual;
		this.warranty = warranty;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getPlaybackMedia() {
		return playbackMedia;
	}
	public void setPlaybackMedia(String playbackMedia) {
		this.playbackMedia = playbackMedia;
	}
	public String getAntenna() {
		return antenna;
	}
	public void setAntenna(String antenna) {
		this.antenna = antenna;
	}
	public int getStationPresets() {
		return stationPresets;
	}
	public void setStationPresets(int stationPresets) {
		this.stationPresets = stationPresets;
	}
	public String getTunerBands() {
		return tunerBands;
	}
	public void setTunerBands(String tunerBands) {
		this.tunerBands = tunerBands;
	}
	public int getPackagingHeight() {
		return packagingHeight;
	}
	public void setPackagingHeight(int packagingHeight) {
		this.packagingHeight = packagingHeight;
	}
	public int getPackagingWidth() {
		return packagingWidth;
	}
	public void setPackagingWidth(int packagingWidth) {
		this.packagingWidth = packagingWidth;
	}
	public int getPackagingDepth() {
		return packagingDepth;
	}
	public void setPackagingDepth(int packagingDepth) {
		this.packagingDepth = packagingDepth;
	}
	public int getPowerSupply() {
		return powerSupply;
	}
	public void setPowerSupply(int powerSupply) {
		this.powerSupply = powerSupply;
	}
	public int getNumberOfSpeakers() {
		return numberOfSpeakers;
	}
	public void setNumberOfSpeakers(int numberOfSpeakers) {
		this.numberOfSpeakers = numberOfSpeakers;
	}
	public String getLoudspeakerEnhancement() {
		return loudspeakerEnhancement;
	}
	public void setLoudspeakerEnhancement(String loudspeakerEnhancement) {
		this.loudspeakerEnhancement = loudspeakerEnhancement;
	}
	public String getSpeakerTypes() {
		return speakerTypes;
	}
	public void setSpeakerTypes(String speakerTypes) {
		this.speakerTypes = speakerTypes;
	}
	public String getSoundPower() {
		return soundPower;
	}
	public void setSoundPower(String soundPower) {
		this.soundPower = soundPower;
	}
	public int getHeadphone() {
		return headphone;
	}
	public void setHeadphone(int headphone) {
		this.headphone = headphone;
	}
	public String getMicroPhone() {
		return microPhone;
	}
	public void setMicroPhone(String microPhone) {
		this.microPhone = microPhone;
	}
	public String getUsb() {
		return usb;
	}
	public void setUsb(String usb) {
		this.usb = usb;
	}
	public String getMp3Link() {
		return mp3Link;
	}
	public void setMp3Link(String mp3Link) {
		this.mp3Link = mp3Link;
	}
	public int getRmtctrl() {
		return rmtctrl;
	}
	public void setRmtctrl(int rmtctrl) {
		this.rmtctrl = rmtctrl;
	}
	public int getUserManual() {
		return userManual;
	}
	public void setUserManual(int userManual) {
		this.userManual = userManual;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	

}
