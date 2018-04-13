package com.resonance.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resonance.model.impl.Product;
import com.resonance.service.processor.ServiceProcessor;

@RestController
@RequestMapping(value ="/resonance/v1/products")
public class ProductController {

	@Autowired
	@Qualifier(value="productServiceProcessor")
	private ServiceProcessor<Product> productServiceProcessor;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> postProducts(@Valid @RequestBody Product product){
		
		productServiceProcessor.postRequest(product);
		product.add(linkTo(methodOn(ProductController.class).postProducts(product)).slash(product.generateIdFromModel()).withSelfRel());
		return new ResponseEntity<>(product, HttpStatus.CREATED);
		
	}
}
