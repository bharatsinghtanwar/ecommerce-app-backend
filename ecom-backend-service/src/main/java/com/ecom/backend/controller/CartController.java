package com.ecom.backend.controller;


import com.ecom.backend.model.Cart;
import com.ecom.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addToCart(userId, productId, quantity);
    }

    @DeleteMapping("/remove")
    public Cart removeFromCart(@RequestParam Long userId, @RequestParam Long productId) {
        return cartService.removeFromCart(userId, productId);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }
}
