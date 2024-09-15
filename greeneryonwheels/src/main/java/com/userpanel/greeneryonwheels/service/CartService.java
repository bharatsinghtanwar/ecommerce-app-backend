package com.userpanel.greeneryonwheels.service;


import com.userpanel.greeneryonwheels.dao.CartRepository;
import com.userpanel.greeneryonwheels.dao.ProductRepository;
import com.userpanel.greeneryonwheels.model.Cart;
import com.userpanel.greeneryonwheels.model.CartItem;
import com.userpanel.greeneryonwheels.model.Product;
import com.userpanel.greeneryonwheels.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart addToCart(Long userId, Long productId, int quantity) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        Product product = productOpt.get();

        Cart cart = cartRepository.findByUserId(userId).orElse(new Cart());
        cart.setUser(new User(userId));

        // Find existing cart item
        Optional<CartItem> existingItemOpt = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItemOpt.isPresent()) {
            CartItem existingItem = existingItemOpt.get();
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            existingItem.setPrice(existingItem.getQuantity() * product.getPrice());
        } else {
            CartItem newItem = new CartItem();
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            newItem.setPrice(product.getPrice() * quantity);
            cart.getCartItems().add(newItem);
        }

        cart.setTotalPrice(cart.getCartItems().stream().mapToDouble(CartItem::getPrice).sum());

        return cartRepository.save(cart);
    }

    public Cart removeFromCart(Long userId, Long productId) {
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.getCartItems().removeIf(item -> item.getProduct().getId().equals(productId));

        cart.setTotalPrice(cart.getCartItems().stream().mapToDouble(CartItem::getPrice).sum());

        return cartRepository.save(cart);
    }

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}
