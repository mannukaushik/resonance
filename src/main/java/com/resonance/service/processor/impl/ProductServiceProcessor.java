package com.resonance.service.processor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resonance.data.repo.ProductRepository;
import com.resonance.entities.ProductTo;
import com.resonance.model.impl.Product;
import com.resonance.service.processor.ServiceProcessor;

@Service
public class ProductServiceProcessor implements ServiceProcessor<Product> {

	@Autowired
	private ProductRepository productRepoObj;
	
	public void getResponse(Product model) {
		// TODO Auto-generated method stub
		
	}

	public void getResponseById(Product model) {
		// TODO Auto-generated method stub
		
	}

	public void postRequest(Product productObj) {		
		ProductTo productTo = new ProductTo(productObj.getModelName(), productObj.getPrice(), productObj.getImgSrc());
		productRepoObj.save(productTo);
	}

	public void processDelete(Product model) {
		// TODO Auto-generated method stub
		
	}

	public void processPatch(Product model) {
		// TODO Auto-generated method stub
		
	}


	

}
