package com.resonance.service.processor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postRequest(Specification specObj) {
		SpecTo specTo = new SpecTo(specObj.getModelName(), specObj.getPlaybackMedia(), specObj.getAntenna(), specObj.getStationPresets(), specObj.getTunerBands(), specObj.getPackagingHeight(), specObj.getPackagingWidth(), specObj.getPackagingDepth(), specObj.getPowerSupply(), specObj.getNumberOfSpeakers(), specObj.getLoudspeakerEnhancement(), specObj.getSpeakerTypes(),  specObj.getSoundPower(), specObj.getHeadphone(), specObj.getMicroPhone(), specObj.getUsb(), specObj.getMp3Link(), specObj.getRmtctrl(), specObj.getUserManual(), specObj.getWarranty());
		specRepoObj.save(specTo);
		
	}

	@Override
	public void processDelete(Specification specsObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processPatch(Specification specsObj) {
		// TODO Auto-generated method stub
		
	}
}
