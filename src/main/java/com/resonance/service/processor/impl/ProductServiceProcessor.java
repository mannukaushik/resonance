package com.resonance.service.processor.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.resonance.api.elements.DataNotFoundException;
import com.resonance.data.repo.ProductRepository;
import com.resonance.entities.ProductTo;
import com.resonance.model.impl.Product;
import com.resonance.service.processor.ServiceProcessor;

@Service
public class ProductServiceProcessor implements ServiceProcessor<Product> {

	@Autowired
	private ProductRepository productRepoObj;
	
	public List<Product> getResponse(Product productObj, Integer page, Integer size) {
		Optional<String> productOptionaltype = Optional.ofNullable(productObj.getType());
		if(page!=null && size!=null && !productOptionaltype.isPresent()) {
			Page<ProductTo> productToList = productRepoObj.findAll(PageRequest.of(page, size));
			return fetchProductList(productObj, productToList);
		}
		else if(page != null && size != null && productOptionaltype.isPresent()) {
			Page<ProductTo> productToList = productRepoObj.findPagedTypes(productObj.getType(),PageRequest.of(page, size));
			return fetchProductList(productObj, productToList);
		}
		else if(productOptionaltype.isPresent()){
			List<ProductTo> productToList = productRepoObj.findTypes(productObj.getType());
			return fetchProductList(productObj, productToList);
		}
		else {
			List<ProductTo> productToList = productRepoObj.findAll();
			return fetchProductList(productObj, productToList);
		}
	}
		
	private List<Product> fetchProductList(Product productObj, Iterable<ProductTo> productToList){
		List<Product> productList = new ArrayList<Product>();
		for(ProductTo productTo : productToList) {
			productObj = new Product(productTo.getModelName(), productTo.getPrice(), productTo.getImgSrc(), productTo.getType());
			productList.add(productObj);
		}
		return productList;
	}
	
	public Product getResponseById(Product productObj) {
		ProductTo productTo = productRepoObj.findUnique(productObj.getModelName());
		if(null==productTo) {
			throw new DataNotFoundException("No data found");
		}
		productObj.setModelName(productTo.getModelName());
		productObj.setPrice(productTo.getPrice());
		productObj.setImgSrc(productTo.getImgSrc());
		productObj.setType(productTo.getType());
		return productObj;
	}

	public void postRequest(Product productObj) {		

		ProductTo productTo = new ProductTo(productObj.getModelName(), productObj.getPrice(), productObj.getImgSrc(), productObj.getType());
		productRepoObj.save(productTo);
	}

	public void processDelete(Product productObj) {
		ProductTo productTo = new ProductTo(productObj.getModelName());
		productRepoObj.delete(productTo);
	}

	public void processPatch(Product model) {
		
	}
}
