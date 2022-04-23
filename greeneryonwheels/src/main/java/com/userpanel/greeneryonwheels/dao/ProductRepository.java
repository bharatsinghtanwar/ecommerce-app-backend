package com.userpanel.greeneryonwheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userpanel.greeneryonwheels.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
