package com.resonance.api.elements;

import org.springframework.hateoas.ResourceSupport;

public class ResponseModel extends ResourceSupport{
	ResponseMessageModel messages;
	
	public ResponseMessageModel getMessages() {
		return messages;
	}
	public void setMessages(ResponseMessageModel messages) {
		this.messages = messages;
	}	
}
