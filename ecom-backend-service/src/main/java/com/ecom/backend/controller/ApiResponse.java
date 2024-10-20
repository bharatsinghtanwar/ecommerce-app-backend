package com.ecom.backend.controller;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiResponse {

	private final boolean success;
	private final String message;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public String getTimeStamp() {
		return LocalDateTime.now().toString();
	}
	
}
