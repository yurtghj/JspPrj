package com.newlecture.jspweb.entity;

public class Role {

	private String id;
	private String Introduction;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(String id, String introduction) {
		this.id = id;
		Introduction = introduction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntroduction() {
		return Introduction;
	}

	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	
	
}
