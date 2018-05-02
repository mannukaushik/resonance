package com.resonance.controllers.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resonance.controllers.AbstractController;
import com.resonance.model.impl.Specification;
import com.resonance.service.processor.ServiceProcessor;

@RestController
@RequestMapping("/specifications")
public class SpecificationController implements AbstractController {
	
	@Autowired
	@Qualifier(value="specServiceProcessor")
	private ServiceProcessor<Specification> specServiceProcessor;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> postSpecifications(@Valid @RequestBody Specification specification, HttpServletResponse response){
		specServiceProcessor.postRequest(specification);
		specification.add(linkTo(methodOn(SpecificationController.class).postSpecifications(specification, response)).slash(specification.generateIdFromModel()).withSelfRel());
		response.setHeader(HttpHeaders.ALLOW, "POST, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, OPTIONS");
		return new ResponseEntity<>(specification, HttpStatus.CREATED);
		
	}
}
