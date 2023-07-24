package com.example.demosprinng.service;

import com.example.demosprinng.entity.Cart;
import com.example.demosprinng.entity.CartProduct;
import com.example.demosprinng.entity.Product;
import com.example.demosprinng.repository.CartProductRepository;
import com.example.demosprinng.repository.CartRepository;
import com.example.demosprinng.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartProductRepository cartProductRepository;
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public Cart createCart() {
        Cart cart = new Cart();
        cart.setQuantityTotalProduct(0);
        cart.setTotalPrice(0);
        return cartRepository.save(cart);
    }

    public CartProduct addToCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        if (cart != null && product != null) {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setCartId(cartId);
            cartProduct.setProductId(productId);
            cartProduct.setQuantity(1);

            cart.setQuantityTotalProduct(cart.getQuantityTotalProduct() + 1);
            cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());

            cartRepository.save(cart);
            return cartProductRepository.save(cartProduct);
        }

        return null;
    }

    public void removeFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);

        if (cart != null && product != null) {
            CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
            cartProductRepository.delete(cartProduct);
            cart.setQuantityTotalProduct(cart.getQuantityTotalProduct() - 1);
            cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());

            cartRepository.save(cart);
        }
    }
}
