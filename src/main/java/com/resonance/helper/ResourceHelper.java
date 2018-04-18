package com.resonance.helper;

import java.util.List;
import java.util.Set;

import com.resonance.api.elements.Collection;
import com.resonance.api.elements.Item;
import com.resonance.api.elements.JacksonUtils;
import com.resonance.api.elements.LinkSummary;
import com.resonance.model.Model;

public abstract class ResourceHelper<ModelImpl extends Model, Rq, T extends Object> {
	
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
}
