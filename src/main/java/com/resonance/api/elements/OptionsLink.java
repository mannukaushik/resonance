package com.resonance.api.elements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OptionsLink {
	private String title;
	private String method;
	private String rel;
	private String href;
	private List<String> type;
	private Map<String,Object> schema;

	public OptionsLink() {
		super();
	}

	@JsonCreator
	public OptionsLink(@JsonProperty("title") String title, @JsonProperty("method") String method,
			@JsonProperty("href") String href, @JsonProperty("rel") String rel,
			@JsonProperty("schema") HashMap<String,Object> schema, @JsonProperty("type") List<String> type) {
		super();
		this.title = title;
		this.method = method;
		this.rel = rel;
		this.href = href;
		this.schema = schema;
		this.type = type;
	}

	public Map<String, Object> getSchema() {
		return schema;
	}

	public void setSchema(Map<String, Object> map) {
		this.schema = map;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}
}
