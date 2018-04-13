package com.resonance.service.processor;

public interface ServiceProcessor<ModelImpl> {
	
	public void getResponse(ModelImpl model);
	public void getResponseById(ModelImpl model);
	public void postRequest(ModelImpl model);
	public void processDelete(ModelImpl model);
	public void processPatch(ModelImpl model);
	
}
