package com.resonance.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.resonance.api.elements.Collection;
import com.resonance.api.elements.Item;
import com.resonance.api.elements.JacksonUtils;
import com.resonance.api.elements.LinkSummary;
import com.resonance.api.elements.OptionsLink;
import com.resonance.api.elements.OptionsResponseEntity;
import com.resonance.api.elements.SchemaGenerator;
import com.resonance.model.Model;

public abstract class ResourceHelper<ModelImpl extends Model, Rq, T extends Object> {
	
	@Autowired
	private SchemaGenerator schemGenerator;
	
	public void getCollectionResults(Collection collectionObj, String title, String name, String href, Class<ModelImpl> className, List<ModelImpl> results) throws Throwable {
		Set<String> properties = JacksonUtils.getSummaryProperties(className);
		for(int i=0; i<results.size();i++) {
			Item item = new Item();
			item.setHref(href);
			item.setTitle(title);
			item.setName(name);
			item.setSummary(JacksonUtils.publishSummaryObject(results.get(i), className,properties));
			collectionObj.add(new LinkSummary(href, "item", item.getSummary()));
		}
	}
	public abstract OptionsResponseEntity getResourceResponse(Rq rq, Class<ModelImpl> modelClass);

	public abstract OptionsResponseEntity getResourceResponseId(T Id, Rq rq, Class<ModelImpl> modelClass);
	
	public OptionsLink addCollectionOptionsLink(String href, String methodName, String title, String rel, Class<ModelImpl> className) {
		OptionsLink optionsLink = new OptionsLink();
		
		optionsLink.setHref(href);
		optionsLink.setMethod(methodName);
		optionsLink.setTitle(title);
		optionsLink.setRel(rel);
		generateSchema(optionsLink, className);
		return optionsLink;
	}
	private void generateSchema(OptionsLink optionsLink, Class<ModelImpl> className) {
		try {
			schemGenerator.SchemaGeneratorHandler(className, "");
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
