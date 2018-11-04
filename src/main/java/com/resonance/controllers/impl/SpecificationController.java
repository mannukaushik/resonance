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
import com.resonance.helper.generic.SpecificationHelper;
import com.resonance.model.impl.Specification;
import com.resonance.service.processor.ServiceProcessor;

@RestController
@RequestMapping("/products/{Id}/specifications")
public class SpecificationController implements AbstractController {
	
	@Autowired
	@Qualifier(value="specServiceProcessor")
	private ServiceProcessor<Specification> specServiceProcessor;
	
	@Autowired
	private SpecificationHelper specificationHelper;
	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> postSpecifications(@Valid @RequestBody Specification specification, HttpServletResponse response){
		specServiceProcessor.postRequest(specification);
		specification.add(linkTo(methodOn(SpecificationController.class).postSpecifications(specification, response)).slash(specification.generateIdFromModel()).withSelfRel());
		response.setHeader(HttpHeaders.ALLOW, "POST, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, OPTIONS");
		return new ResponseEntity<>(specification, HttpStatus.CREATED);
		
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> getSpecifications(@RequestParam(required=false) Integer page,@RequestParam(required=false) Integer size, @RequestParam(required=false) String modelName, @RequestParam(required=false) String price, HttpServletRequest request, HttpServletResponse response) throws Throwable{
		Collection collectionObj = new Collection();
		Specification specObj = new Specification();
		List<Specification> specList = specServiceProcessor.getResponse(specObj, page, size);
		collectionObj.add(linkTo(methodOn(SpecificationController.class).getSpecifications(page, size, modelName, price, request, response)).withSelfRel().expand());
		specificationHelper.getCollectionResults(collectionObj, "gets a specification resource", "specification", request.getRequestURL().toString(), Specification.class, specList);
		response.setHeader(HttpHeaders.ALLOW, "GET, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS");
		return new ResponseEntity<>(collectionObj, HttpStatus.OK);
	}

	@GetMapping(value = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> getSpecificationsId(@PathVariable("Id") String id, HttpServletResponse response) throws Throwable{
		Specification specObj = new Specification();
		specObj.setModelName(id);
	    specServiceProcessor.getResponseById(specObj);
	    specObj.add(linkTo(methodOn(ProductController.class).getProductsId(id, response)).withSelfRel());
		response.setHeader(HttpHeaders.ALLOW, "GET, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS");
		return new ResponseEntity<>(specObj, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> deleteSpecifications(@PathVariable("Id") String id, HttpServletResponse response) {
		Specification specObj = new Specification();
		specObj.setModelName(id);
		specServiceProcessor.processDelete(specObj);
		specObj.add(linkTo(methodOn(ProductController.class).deleteProducts(id, response)).withSelfRel());
		response.setHeader(HttpHeaders.ALLOW, "DELETE, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "DELETE, OPTIONS");
		return new ResponseEntity<>(specObj, HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.OPTIONS, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> optionsOnSpecifications(HttpServletRequest request, HttpServletResponse response){
		OptionsResponseEntity optionsResponse = specificationHelper.getResourceResponse(request, Specification.class);
		response.setHeader(HttpHeaders.ALLOW, "GET,POST,DELETE,OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,DELETE,OPTIONS");
		return new ResponseEntity<>(optionsResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{Id}", method = RequestMethod.OPTIONS, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> optionsOnProductsId(@PathVariable("Id") String id, HttpServletRequest request, HttpServletResponse response){
		OptionsResponseEntity optionsResponse = specificationHelper.getResourceResponseId(id, request, Specification.class);
		response.setHeader(HttpHeaders.ALLOW, "GET,POST,DELETE,OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,DELETE,OPTIONS");
		return new ResponseEntity<>(optionsResponse, HttpStatus.OK);
	}
}
