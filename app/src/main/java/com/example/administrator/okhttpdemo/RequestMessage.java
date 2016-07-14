package com.example.administrator.okhttpdemo;

public class RequestMessage {

	private String deviceType; // the type of client type. ios or android...
	private String reqMessage; // the content from client send to server.

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getReqMessage() {
		return reqMessage;
	}

	public void setReqMessage(String reqMessage) {
		this.reqMessage = reqMessage;
	}

}
