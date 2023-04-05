package com.rclgroup.dolphin.web.model;

import java.util.List;

import com.rclgroup.dolphin.web.servlet.ConfigServlet;

public class ResponseMod<T> {
	private List<T> data;
	private boolean status;
	private String statusId;
	
	

	public String getStatusId() {
		return statusId;
	}
	
	public String getStatusAsString() {
		return ConfigServlet.getStatus(statusId);
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public ResponseMod(List<T> data, boolean status) {
		this.data = data;
		this.status = status;
	}

	public List<T> getData() {
		return data;
	}

	public boolean isStatus() {
		return status;
	}

}
