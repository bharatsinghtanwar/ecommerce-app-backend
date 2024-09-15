package com.userpanel.greeneryonwheels.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_profile")
public class UserProfile {
	@Id
	private String Id;
	private UserCredentials userCredentials;
	private String firstname;
	private String middlename;
	private String lastname;
	private Date dob;
	private UserAddress address;
	private long phoneNumber;
	
	
}
