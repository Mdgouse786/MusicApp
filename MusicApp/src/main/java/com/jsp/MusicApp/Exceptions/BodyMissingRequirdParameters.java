package com.jsp.MusicApp.Exceptions;

public class BodyMissingRequirdParameters extends RuntimeException {
	
	private String msg;
	public BodyMissingRequirdParameters(String msg) {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
