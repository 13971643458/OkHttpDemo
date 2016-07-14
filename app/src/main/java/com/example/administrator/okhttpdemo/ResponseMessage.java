package com.example.administrator.okhttpdemo;

import java.io.Serializable;

public class ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int resultCode;		//已经定义好的接口返回代码
	private String resultMessage;	//接口代码的中文解释
	private String dataContent;		//返回客户端的业务数据

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getDataContent() {
		return dataContent;
	}

	public void setDataContent(String dataContent) {
		this.dataContent = dataContent;
	}

}
