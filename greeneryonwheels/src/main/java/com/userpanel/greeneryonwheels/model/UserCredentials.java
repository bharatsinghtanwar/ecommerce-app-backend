package com.userpanel.greeneryonwheels.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentials {

	private int userid;
	private String email;
	private String password;
	
}
