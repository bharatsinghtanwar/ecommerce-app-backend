package com.userpanel.greeneryonwheels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userpanel.greeneryonwheels.model.Products;
import com.userpanel.greeneryonwheels.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")	
	public ResponseEntity<List<Products>> getProducts(){
		
		List<Products> body = productService.listOfProducts();
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
}
