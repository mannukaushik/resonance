package com.resonance.helper.generic;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;

import com.resonance.api.elements.Options;
import com.resonance.api.elements.OptionsResponseEntity;
import com.resonance.api.elements.StringConstants;
import com.resonance.controllers.impl.ProductController;
import com.resonance.helper.ResourceHelper;
import com.resonance.model.impl.Specification;

public class SpecificationHelper extends ResourceHelper<Specification, HttpServletRequest, String> {

	public static final String SPECIFICATION_TITLE = "Options for Specification Id";
	public static final String SPECIFICATION_RESOURCE_GET_TITLE = "Searches the Specifications";
	public static final String SPECIFICATION_RESOURCE_POST_TITLE = "Creates a new Specification";
	public static final String SPECIFICATION_RESOURCE_GET_ID_TITLE = "Fetches the Specification from the Id";
	public static final String SPECIFICATION_RESOURCE_DELETE_TITLE = "Deletes the Specification based on the Id";
	
	@Override
	public OptionsResponseEntity getResourceResponse(HttpServletRequest request, Class<Specification> modelClass) {
		
		OptionsResponseEntity optionsResponseEntity = new OptionsResponseEntity();
		Options _options = new Options();

		optionsResponseEntity.setTitle(SPECIFICATION_TITLE);
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.GET.name(), SPECIFICATION_RESOURCE_GET_TITLE, StringConstants.GET_REL, Specification.class));
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.POST.name(), SPECIFICATION_RESOURCE_POST_TITLE, StringConstants.POST_REL, Specification.class));
		optionsResponseEntity.setOptions(_options);
		optionsResponseEntity.add(linkTo(methodOn(ProductController.class).optionsOnProducts(request, null)).withSelfRel().expand());
		return optionsResponseEntity;
	}

	@Override
	public OptionsResponseEntity getResourceResponseId(String id, HttpServletRequest request, Class<Specification> modelClass) {
	
		OptionsResponseEntity optionsResponseEntity = new OptionsResponseEntity();
		Options _options = new Options();

		optionsResponseEntity.setTitle(SPECIFICATION_TITLE);
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.GET.name(), SPECIFICATION_RESOURCE_GET_TITLE, StringConstants.GET_ID_REL, Specification.class));
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.DELETE.name(), SPECIFICATION_RESOURCE_DELETE_TITLE, StringConstants.DELETE_REL, Specification.class));
		optionsResponseEntity.setOptions(_options);
		optionsResponseEntity.add(linkTo(methodOn(ProductController.class).optionsOnProductsId(id, request, null)).withSelfRel().expand(id, request, modelClass));
		return optionsResponseEntity;
	}

}
