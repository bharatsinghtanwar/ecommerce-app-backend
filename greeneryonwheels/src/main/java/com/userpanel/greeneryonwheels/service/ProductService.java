package com.userpanel.greeneryonwheels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userpanel.greeneryonwheels.dao.ProductRepository;
import com.userpanel.greeneryonwheels.model.Products;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository productrepo;
	
	public List<Products> listOfProducts(){
		
		return productrepo.findAll();
	}
}
