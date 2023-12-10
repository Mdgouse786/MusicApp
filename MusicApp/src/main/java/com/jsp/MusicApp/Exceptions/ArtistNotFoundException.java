package com.jsp.MusicApp.Exceptions;

public class ArtistNotFoundException extends RuntimeException {
	private String msg;
	
	public ArtistNotFoundException( ) {
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
