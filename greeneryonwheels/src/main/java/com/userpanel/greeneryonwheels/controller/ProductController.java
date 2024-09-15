package com.userpanel.greeneryonwheels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.userpanel.greeneryonwheels.model.Products;
import com.userpanel.greeneryonwheels.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")	
	public ResponseEntity<List<Products>> getProducts(){
		
		List<Products> productsList = productService.listOfProducts();
		return new ResponseEntity<>(productsList, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Products> saveProducts(@RequestBody Products products){
		Products products1 = productService.persisTheProduct(products);
		return new ResponseEntity<>(products1, HttpStatus.OK);
	}
}
