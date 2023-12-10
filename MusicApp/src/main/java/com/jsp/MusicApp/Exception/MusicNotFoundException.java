package com.jsp.MusicApp.Exception;

public class MusicNotFoundException extends RuntimeException {
	private String msg="";
	public MusicNotFoundException(String msg) {
		super();
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
