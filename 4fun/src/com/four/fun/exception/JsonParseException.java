package com.four.fun.exception;

public class JsonParseException extends CustomException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5223277389766736728L;

	public JsonParseException(String msg){
		super(msg);
	}
	
	public JsonParseException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public JsonParseException(Throwable cause) {
		super(cause);
	}
	

	public JsonParseException(int code, String msg, Throwable cause) {
		super(code, msg, cause);
	}

	public JsonParseException(int code) {
		super(code);
	}
	
	public JsonParseException(int code, Throwable cause){
		super(code, cause);
	}

	public JsonParseException(int code, String msg) {
		super(code, msg);
	}
}
