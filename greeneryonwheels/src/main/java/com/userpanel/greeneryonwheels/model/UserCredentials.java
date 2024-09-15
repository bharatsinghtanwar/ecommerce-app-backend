package com.userpanel.greeneryonwheels.model;

import lombok.*;

import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_credentials")
public class UserCredentials {

	private int userid;
	private String email;
	private String password;
	
}
