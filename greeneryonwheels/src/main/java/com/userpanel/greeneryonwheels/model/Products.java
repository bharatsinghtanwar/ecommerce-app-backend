package com.userpanel.greeneryonwheels.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

	@Id
	private int productid;
	private String name;
	private String Description;
	private double price;
}
