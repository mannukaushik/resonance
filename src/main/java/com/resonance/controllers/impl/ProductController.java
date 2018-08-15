package com.resonance.controllers.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resonance.api.elements.Collection;
import com.resonance.api.elements.OptionsResponseEntity;
import com.resonance.controllers.AbstractController;
import com.resonance.helper.generic.ProductHelper;
import com.resonance.model.impl.Product;
import com.resonance.service.processor.ServiceProcessor;


@RestController
@RequestMapping("/products")
public class ProductController implements AbstractController {

	@Autowired
	@Qualifier(value="productServiceProcessor")
	private ServiceProcessor<Product> productServiceProcessor;
	
	@Autowired
	private ProductHelper productHelper;
	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> postProducts(@Valid @RequestBody Product product, HttpServletResponse response){
		productServiceProcessor.postRequest(product);
		product.add(linkTo(methodOn(ProductController.class).postProducts(product, response)).slash(product.generateIdFromModel()).withSelfRel());
		response.setHeader(HttpHeaders.ALLOW, "POST, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, OPTIONS");
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> getProducts(@RequestParam(required=false) Integer page, @RequestParam(required=false) Integer size, @RequestParam(required=false) String modelName, @RequestParam(required=false) String price, @RequestParam(required=false) String type, HttpServletRequest request, HttpServletResponse response) throws Throwable{
		Collection collectionObj = new Collection();
		Product productObj = new Product();
		productObj.setType(type);
		List<Product> productList = productServiceProcessor.getResponse(productObj, page, size);
		collectionObj.add(linkTo(methodOn(ProductController.class).getProducts(page, size, modelName, price, type, request, response)).withSelfRel().expand());
		productHelper.getCollectionResults(collectionObj, "gets a product resource", "product", request.getRequestURL().toString(), Product.class, productList);
		response.setHeader(HttpHeaders.ALLOW, "GET, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS");
		return new ResponseEntity<>(collectionObj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> getProductsId(@PathVariable("Id") String id, HttpServletResponse response) throws Throwable{
		Product productObj = new Product();
		productObj.setModelName(id);
	    productServiceProcessor.getResponseById(productObj);
	    productObj.add(linkTo(methodOn(ProductController.class).getProductsId(id, response)).withSelfRel());
		response.setHeader(HttpHeaders.ALLOW, "GET, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS");
		return new ResponseEntity<>(productObj, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> deleteProducts(@PathVariable("Id") String id, HttpServletResponse response) {
		Product productObj = new Product();
		productObj.setModelName(id);
		productServiceProcessor.processDelete(productObj);
		productObj.add(linkTo(methodOn(ProductController.class).deleteProducts(id, response)).withSelfRel());
		response.setHeader(HttpHeaders.ALLOW, "DELETE, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "DELETE, OPTIONS");
		return new ResponseEntity<>(productObj, HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.OPTIONS, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> optionsOnProducts(HttpServletRequest request, HttpServletResponse response){
		OptionsResponseEntity optionsResponse = productHelper.getResourceResponse(request, Product.class);
		response.setHeader(HttpHeaders.ALLOW, "GET,POST,DELETE,OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,DELETE,OPTIONS");
		return new ResponseEntity<>(optionsResponse, HttpStatus.OK);
	}
	@RequestMapping(value = "/{Id}", method = RequestMethod.OPTIONS, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> optionsOnProductsId(@PathVariable("Id") String id, HttpServletRequest request, HttpServletResponse response){
		OptionsResponseEntity optionsResponse = productHelper.getResourceResponseId(id, request, Product.class);
		response.setHeader(HttpHeaders.ALLOW, "GET,POST,DELETE,OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,DELETE,OPTIONS");
		return new ResponseEntity<>(optionsResponse, HttpStatus.OK);
	}
}
