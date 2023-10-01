package com.smart.helper;

public class Message {
	private String content;
	private String typeContent;
	public Message(String content, String typeContent) {
		super();
		this.content = content;
		this.typeContent = typeContent;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTypeContent() {
		return typeContent;
	}
	public void setTypeContent(String typeContent) {
		this.typeContent = typeContent;
	}
	
	
}
