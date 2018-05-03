package com.resonance.service.processor.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.resonance.data.repo.SpecificationRepository;
import com.resonance.entities.SpecTo;
import com.resonance.model.Model;
import com.resonance.model.impl.Specification;
import com.resonance.service.processor.ServiceProcessor;

@Service
public class SpecServiceProcessor implements ServiceProcessor<Specification>  {

	@Autowired
	private SpecificationRepository specRepoObj;

	public List<Specification> getResponse(Specification model, int page, int size) {
		return null;
	}

	@Override
	public Model getResponseById(Specification specObj) {
		SpecTo specTo = specRepoObj.findUnique(specObj.getModelName());
		specObj.setModelName(specTo.getModelName());
		specObj.setPlaybackMedia(specTo.getPlaybackMedia()); 
		specObj.setAntenna(specTo.getAntenna());
		specObj.setStationPresets(specTo.getStationPresets());
		specObj.setTunerBands(specTo.getTunerBands()); 
		specObj.setPackagingHeight(specTo.getPackagingHeight()); 
		specObj.setPackagingWidth(specTo.getPackagingWidth());
		specObj.setPackagingDepth(specTo.getPackagingDepth());
		specObj.setPowerSupply(specTo.getPowerSupply());
		specObj.setNumberOfSpeakers(specTo.getNumberOfSpeakers());
		specObj.setLoudspeakerEnhancement(specTo.getLoudspeakerEnhancement());
		specObj.setSpeakerTypes(specTo.getSpeakerTypes());
		specObj.setSoundPower(specTo.getSoundPower());
		specObj.setHeadphone(specTo.getHeadphone());
		specObj.setMicroPhone(specTo.getMicroPhone()); 
		specObj.setUsb(specTo.getUsb());
		specObj.setMp3Link(specTo.getMp3Link()); 
		specObj.setRmtctrl(specTo.getRmtctrl());
		specObj.setUserManual(specTo.getUserManual());
		specObj.setWarranty(specTo.getWarranty());
		return specObj;
	}

	@Override
	public void postRequest(Specification specObj) {
		SpecTo specTo = new SpecTo(specObj.getModelName(), specObj.getPlaybackMedia(), specObj.getAntenna(), specObj.getStationPresets(), specObj.getTunerBands(), specObj.getPackagingHeight(), specObj.getPackagingWidth(), specObj.getPackagingDepth(), specObj.getPowerSupply(), specObj.getNumberOfSpeakers(), specObj.getLoudspeakerEnhancement(), specObj.getSpeakerTypes(),  specObj.getSoundPower(), specObj.getHeadphone(), specObj.getMicroPhone(), specObj.getUsb(), specObj.getMp3Link(), specObj.getRmtctrl(), specObj.getUserManual(), specObj.getWarranty());
		specRepoObj.save(specTo);
		
	}

	@Override
	public void processDelete(Specification specObj) {
		SpecTo specTo = new SpecTo(specObj.getModelName());
		specRepoObj.delete(specTo);
	}

	@Override
	public void processPatch(Specification specsObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Specification> getResponse(Specification specObj, Integer page, Integer size) {
		if(page!=null && size!=null) {
			Page<SpecTo> specToList = specRepoObj.findAll(PageRequest.of(page, size));
			return fetchSpecificationList(specObj, specToList);
		}else {
			List<SpecTo> specToList = specRepoObj.findAll();
			return fetchSpecificationList(specObj, specToList);
		}
	}
	private List<Specification> fetchSpecificationList(Specification specObj, Iterable<SpecTo> SpecToList){
		List<Specification> specList = new ArrayList<Specification>();
		for(SpecTo specTo : SpecToList) {
			specObj = new Specification(specTo.getModelName(), specTo.getPlaybackMedia(), specTo.getAntenna(), specTo.getStationPresets(), specTo.getTunerBands(), specTo.getPackagingHeight(), specTo.getPackagingWidth(), specTo.getPackagingDepth(), specTo.getPowerSupply(), specTo.getNumberOfSpeakers(), specTo.getLoudspeakerEnhancement(), specTo.getSpeakerTypes(),  specTo.getSoundPower(), specTo.getHeadphone(), specTo.getMicroPhone(), specTo.getUsb(), specTo.getMp3Link(), specTo.getRmtctrl(), specTo.getUserManual(), specTo.getWarranty());
			specList.add(specObj);
		}
		return specList;
	}
}
