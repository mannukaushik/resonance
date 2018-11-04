package com.resonance.service.processor.impl;

import java.util.ArrayList;
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
	public List<Overview> getResponse(Overview overview, Integer page, Integer size) {
		List<OverviewTo> overviewToList = overviewRepoObj.findAll();
		List<Overview> overviewList = new ArrayList<>();
		overviewToList.forEach((overviewTo)->
		{
			overview.setModelName(overviewTo.getModelName());
			overview.setDescription(overviewTo.getDescription());
			overview.setBluetooth(overviewTo.getBluetooth());
			overview.setDvdPlayback(overviewTo.getDvdPlayback());
			overview.setBlueRay(overviewTo.getBlueRay());
			overview.setPower(overviewTo.getModelName());
			overview.setSubWoofer(overviewTo.getSubWoofer());
			overviewList.add(overview);
		});
		
		return overviewList;
	}

	@Override
	public Model getResponseById(Overview overviewObj) {
		OverviewTo overviewTo = overviewRepoObj.findUnique(overviewObj.getModelName());
		overviewObj.setModelName(overviewTo.getModelName());
		overviewObj.setDescription(overviewTo.getDescription());
		return overviewObj;
	}

	@Override
	public void postRequest(Overview overviewObj) {
		OverviewTo overviewTo = new OverviewTo(overviewObj.getModelName(), overviewObj.getDescription(), overviewObj.getBluetooth(), overviewObj.getSubWoofer(), overviewObj.getBlueRay(), overviewObj.getDvdPlayback(), overviewObj.getPower());
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
