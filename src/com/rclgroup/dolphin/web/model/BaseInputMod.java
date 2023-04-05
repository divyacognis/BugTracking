package com.rclgroup.dolphin.web.model;

import java.io.Serializable;

public class BaseInputMod implements Serializable {

	
	private boolean responseStatus= false;
	private static final long serialVersionUID = 1L;
	private String userId;
	private String role;
	private String vesselCode;
	private String loginUserEmailId;
	private String buildNumber="106";
	
	
	 

	public String getLoginUserEmailId() {
		return loginUserEmailId;
	}

	public void setLoginUserEmailId(String loginUserEmailId) {
		this.loginUserEmailId = loginUserEmailId;
	}

	public String getVesselCode() {
		return vesselCode;
	}

	public void setVesselCode(String vesselCode) {
		this.vesselCode = vesselCode;
	}

	public String getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(String buildNumber) {
		this.buildNumber = buildNumber;
	}

	 
    
	private String seq;
	 

	 

	 

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(boolean responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "BaseInputMod [browserData=" + userId + ", seq=" + seq + "]";
	}
	
}
