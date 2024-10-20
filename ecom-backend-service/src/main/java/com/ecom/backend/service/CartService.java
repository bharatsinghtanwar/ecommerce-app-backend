package com.ecom.backend.service;


import com.ecom.backend.dao.CartRepository;
import com.ecom.backend.dao.ProductRepository;
import com.ecom.backend.model.Cart;
import com.ecom.backend.model.CartItem;
import com.ecom.backend.model.Product;
import com.ecom.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        Optional<Cart> cart = cartRepository.findByUserId(userId);
        if (cart.isPresent()){
            Optional<CartItem> existingItemOpt = cart.get().getCartItems().stream()
                    .filter(item -> item.getProduct().getId().equals(productId))
                    .findFirst();
            if(existingItemOpt.isPresent()){
                CartItem existingItem = existingItemOpt.get();
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
                existingItem.setPrice(existingItem.getQuantity() * product.getPrice());
                cart.get().setTotalPrice(cart.get().getCartItems().stream().mapToDouble(CartItem::getPrice).sum());
                return cartRepository.save(cart.get());
            } else{
                CartItem newCartItems = new CartItem();
                newCartItems.setQuantity(quantity);
                newCartItems.setPrice(newCartItems.getQuantity() * product.getPrice());
                cart.get().setTotalPrice(newCartItems.getPrice());
                return cartRepository.save(cart.get());
            }

        } else {
            Cart cart1 = new Cart();
            cart1.setUser(new User(userId));
            cart1.setTotalPrice(0.0);
            Cart newCart = cartRepository.save(cart1);

            CartItem newItem = new CartItem();
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            newItem.setPrice(product.getPrice() * quantity);
            List<CartItem> cartItemList = new ArrayList<>();
            cartItemList.add(newItem);
            newCart.setCartItems(cartItemList);
            newCart.setTotalPrice(newCart.getCartItems().stream().mapToDouble(CartItem::getPrice).sum());
            return cartRepository.save(newCart);
        }
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
