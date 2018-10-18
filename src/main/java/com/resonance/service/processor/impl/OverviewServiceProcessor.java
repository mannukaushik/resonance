package com.resonance.service.processor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resonance.data.repo.OverviewRepository;
import com.resonance.entities.OverviewTo;
import com.resonance.model.Model;
import com.resonance.model.impl.Overview;
import com.resonance.service.processor.ServiceProcessor;

@Service
public class OverviewServiceProcessor implements ServiceProcessor<Overview> {

	
	@Autowired
	private OverviewRepository overviewRepoObj;
	
	@Override
	public List<Overview> getResponse(Overview model, Integer page, Integer size) {
		return null;
	}

	@Override
	public Model getResponseById(Overview overviewObj) {
		OverviewTo overviewTo = overviewRepoObj.findUnique(overviewObj.getModelName());
		overviewObj.setModelName(overviewTo.getModelName());
		overviewObj.setDescriptionHeader(overviewTo.getDescriptionHeader());
		overviewObj.setDescription(overviewTo.getDescription());
		overviewObj.setImgSrc(overviewTo.getImgSrc());
		return overviewObj;
	}

	@Override
	public void postRequest(Overview overviewObj) {
		OverviewTo overviewTo = new OverviewTo(overviewObj.getModelName(), overviewObj.getDescriptionHeader(), overviewObj.getDescription(), overviewObj.getImgSrc());
		overviewRepoObj.save(overviewTo);
	}

	@Override
	public void processDelete(Overview overviewObj) {
		OverviewTo overviewTo = new OverviewTo(overviewObj.getModelName());
		overviewRepoObj.delete(overviewTo);
	}

	@Override
	public void processPatch(Overview model) {
		
	}

}
