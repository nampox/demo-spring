package com.example.demosprinng.controller;

import com.example.demosprinng.entity.Cart;
import com.example.demosprinng.entity.CartProduct;
import com.example.demosprinng.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping(path = "findAll")
    public CartProduct addToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return cartService.addToCart(cartId, productId);
    }

    @GetMapping(path = "")
    public Cart getCart(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    @DeleteMapping(path = "delete")
    public String removeFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        cartService.removeFromCart(cartId, productId);
        return "Xoá sản phẩm khỏi g iỏ hàng thành công";
    }
}
