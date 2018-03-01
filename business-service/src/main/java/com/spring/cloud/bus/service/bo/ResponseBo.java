package com.spring.cloud.bus.service.bo;

import java.io.Serializable;

public class ResponseBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6669076532235146170L;
	
	private String code;
	
	private String msg;
	private Result result;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	

}
