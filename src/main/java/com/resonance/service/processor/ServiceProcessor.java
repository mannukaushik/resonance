package com.resonance.service.processor;

import java.util.List;

import com.resonance.model.Model;

public interface ServiceProcessor<ModelImpl> {
	
	public List<ModelImpl> getResponse(ModelImpl model, int page, int size);
	public Model getResponseById(ModelImpl model);
	public void postRequest(ModelImpl model);
	public void processDelete(ModelImpl model);
	public void processPatch(ModelImpl model);
	
}
