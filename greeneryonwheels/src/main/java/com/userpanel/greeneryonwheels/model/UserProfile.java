package com.userpanel.greeneryonwheels.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

	
	private UserCredentials user;
	private String firstname;
	private String middlename;
	private String lastname;
	private String dob;
	private UserAddress address;
	private long phoneNumber;
	
	
}
