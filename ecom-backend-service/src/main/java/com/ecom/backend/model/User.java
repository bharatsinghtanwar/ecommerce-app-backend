package com.ecom.backend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;

	private boolean enabled;

	// Getters and setters

	public User(Long id){
		this.id = id;
	}

	@JsonCreator
	public User(
			@JsonProperty("username") String username,
			@JsonProperty("password") String password,
			@JsonProperty("enabled") boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User() {}
}
