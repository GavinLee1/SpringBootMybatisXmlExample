package com.study.webApi.business.message;

public class GetAccountLevelReq {
	private int id;

	public GetAccountLevelReq() { }

	public GetAccountLevelReq(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
