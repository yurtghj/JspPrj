package com.newlecture.jspweb.entity;

public class MemberRole {
	
	private String member_Id;
	private String rold_Id;
	
	public MemberRole() {
		// TODO Auto-generated constructor stub
	}

	public MemberRole(String member_Id, String rold_Id) {
		this.member_Id = member_Id;
		this.rold_Id = rold_Id;
	}

	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

	public String getRold_Id() {
		return rold_Id;
	}

	public void setRold_Id(String rold_Id) {
		this.rold_Id = rold_Id;
	}


}
