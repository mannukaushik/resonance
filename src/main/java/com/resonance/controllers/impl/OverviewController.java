package com.resonance.controllers.impl;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resonance.controllers.AbstractController;
import com.resonance.model.impl.Overview;
import com.resonance.service.processor.ServiceProcessor;

@RestController
@RequestMapping("/products/{Id}/overview")
public class OverviewController implements AbstractController{

	@Autowired
	@Qualifier(value="overviewServiceProcessor")
	private ServiceProcessor<Overview> overviewServiceProcessor;
	
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> postProducts(@Valid @RequestBody Overview overview, HttpServletResponse response){
		overviewServiceProcessor.postRequest(overview);
		response.setHeader(HttpHeaders.ALLOW, "POST, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST, OPTIONS");
		return new ResponseEntity<>(overview, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> getOverviewId(@PathVariable("Id") String id, HttpServletResponse response) throws Throwable{
		Overview overviewtObj = new Overview();
		overviewtObj.setModelName(id);
		overviewServiceProcessor.getResponseById(overviewtObj);
		response.setHeader(HttpHeaders.ALLOW, "GET, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS");
		return new ResponseEntity<>(overviewtObj, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> deleteOverview(@PathVariable("Id") String id, HttpServletResponse response) {
		Overview overviewObj = new Overview();
		overviewObj.setModelName(id);
		overviewServiceProcessor.processDelete(overviewObj);
		response.setHeader(HttpHeaders.ALLOW, "DELETE, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "DELETE, OPTIONS");
		return new ResponseEntity<>(overviewObj, HttpStatus.NO_CONTENT);
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	protected HttpEntity<?> getOverview(@RequestParam(required=false) Integer page, @RequestParam(required=false) Integer size, HttpServletResponse response) throws Throwable{
		Overview overviewObj = new Overview();
		overviewServiceProcessor.getResponse(overviewObj, page, size);
		response.setHeader(HttpHeaders.ALLOW, "GET, OPTIONS");
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS");
		return new ResponseEntity<>(overviewObj, HttpStatus.OK);
	}
	
	
}
