package com.userpanel.greeneryonwheels.dao;


import com.userpanel.greeneryonwheels.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
