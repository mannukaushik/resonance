package com.resonance.service.processor;

import java.util.List;

import com.resonance.model.Model;

public interface ServiceProcessor<ModelImpl> {
	
	public List<ModelImpl> getResponse(ModelImpl model, Integer page, Integer size);
	public Model getResponseById(ModelImpl model);
	public void postRequest(ModelImpl model);
	public void processDelete(ModelImpl model);
	public void processPatch(ModelImpl model);
	
}
