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
import com.resonance.model.impl.Product;

public class ProductHelper extends ResourceHelper<Product, HttpServletRequest, String> {

	public static final String TYPE = "?type";
	public static final String PRODUCT_TITLE = "Options for Product Id";
	public static final String PRODUCT_RESOURCE_GET_TITLE = "Searches the products";
	public static final String PRODUCT_RESOURCE_POST_TITLE = "Creates a new product";
	public static final String PRODUCT_RESOURCE_GET_ID_TITLE = "Fetches the product from the Id";
	public static final String PRODUCT_RESOURCE_DELETE_TITLE = "Deletes the product based on the Id";
	public static final String PRODUCT_RESOURCE_GET_TITLE_SOUNDBAR = "Returns all the sound bars";
	public static final String PRODUCT_RESOURCE_GET_TYPE_TITLE = "Searches the products with type";

	
	@Override
	public OptionsResponseEntity getResourceResponse(HttpServletRequest request, Class<Product> modelClass) {
		
		OptionsResponseEntity optionsResponseEntity = new OptionsResponseEntity();
		Options _options = new Options();
		
		optionsResponseEntity.setTitle(PRODUCT_TITLE);
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.GET.name(), PRODUCT_RESOURCE_GET_TITLE, StringConstants.GET_REL, Product.class));
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.POST.name(), PRODUCT_RESOURCE_POST_TITLE, StringConstants.POST_REL, Product.class));
		optionsResponseEntity.setOptions(_options);
		optionsResponseEntity.add(linkTo(methodOn(ProductController.class).optionsOnProducts(request, null)).withSelfRel().expand());
		return optionsResponseEntity;
	}

	@Override
	public OptionsResponseEntity getResourceResponseId(String id, HttpServletRequest request, Class<Product> modelClass) {
	
		OptionsResponseEntity optionsResponseEntity = new OptionsResponseEntity();
		Options _options = new Options();

		optionsResponseEntity.setTitle(PRODUCT_TITLE);
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.GET.name(), PRODUCT_RESOURCE_GET_ID_TITLE, StringConstants.GET_ID_REL, Product.class));
		_options.getLinks().add(addCollectionOptionsLink(request.getRequestURL().toString(), RequestMethod.DELETE.name(), PRODUCT_RESOURCE_DELETE_TITLE, StringConstants.DELETE_REL, Product.class));
		optionsResponseEntity.setOptions(_options);
		optionsResponseEntity.add(linkTo(methodOn(ProductController.class).optionsOnProductsId(id, request, null)).withSelfRel().expand(id, request, modelClass));
		return optionsResponseEntity;
	}

}
