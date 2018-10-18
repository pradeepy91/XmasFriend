package com.xmas.game.dto;

public class ResponseError {
	String errorCode;
	String userErrorMessage;
	String systemErrorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getUserErrorMessage() {
		return userErrorMessage;
	}
	public void setUserErrorMessage(String userErrorMessage) {
		this.userErrorMessage = userErrorMessage;
	}
	public String getSystemErrorMessage() {
		return systemErrorMessage;
	}
	public void setSystemErrorMessage(String systemErrorMessage) {
		this.systemErrorMessage = systemErrorMessage;
	}
}
