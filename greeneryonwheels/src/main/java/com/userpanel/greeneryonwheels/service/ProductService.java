package com.userpanel.greeneryonwheels.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userpanel.greeneryonwheels.dao.ProductRepository;
import com.userpanel.greeneryonwheels.model.Products;

import java.util.List;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository productrepo;

	public List<Products> listOfProducts(){
		
		return productrepo.findAll();
	}

	public Products persisTheProduct(Products product){
		return productrepo.save(product);
	}
}
