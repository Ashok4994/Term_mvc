package com.utility;

public class ResponseObject {

	private Boolean status;
	private String response;
	private String role;
	private int manager_id;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setManagerId(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public Integer getManagerId() {
		return manager_id;
	}
}
