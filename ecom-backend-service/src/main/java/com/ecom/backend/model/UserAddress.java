package com.ecom.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_address")
public class UserAddress {

	@Id
	private String addressId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String landmark;
	private String district;
	private String state;
	private String country;
	private int pincode;
}
