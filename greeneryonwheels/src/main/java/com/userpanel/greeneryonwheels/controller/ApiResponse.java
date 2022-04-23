package com.userpanel.greeneryonwheels.controller;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse {

	private final boolean success;
	private final String message;
	
	public String getTimeStamp() {
		return LocalDateTime.now().toString();
	}
	
}
