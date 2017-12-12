package com.jiuwu.openoo.common.openapi.exception;

public class OpenApiBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode = null;
	private String errorMsg = null;
	private String[] params = null;
	private String pkinfo = null;

	public OpenApiBaseException(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public OpenApiBaseException(String errorCode) {
		this.errorCode = errorCode;
	}

	public OpenApiBaseException(Exception exception) {
		this.errorCode = "";
		this.errorMsg = exception.getMessage();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public String getPkinfo() {
		return pkinfo;
	}

	public void setPkinfo(String pkinfo) {
		this.pkinfo = pkinfo;
	}

}
