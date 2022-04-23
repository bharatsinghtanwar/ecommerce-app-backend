package com.userpanel.greeneryonwheels.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String landmark;
	private String district;
	private String state;
	private String country;
	private int pincode;
}
