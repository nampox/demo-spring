package com.example.demosprinng.service;

import com.example.demosprinng.entity.CartProduct;
import com.example.demosprinng.entity.Product;
import com.example.demosprinng.repository.CartProductRepository;
import com.example.demosprinng.repository.CartRepository;
import com.example.demosprinng.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductService {
    @Autowired
    CartProductRepository cartProductRepository;
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;


    public List<CartProduct> findAll(){
        return cartProductRepository.findAll();
    }

    public CartProduct add(CartProduct cartProduct){
        return cartProductRepository.save(cartProduct);
    }

    public String delete(Long id){
        try {
            CartProduct cartProduct = cartProductRepository.getById(id);
            cartProductRepository.delete(cartProduct);
            return "xoa thanh cong oke lan okokokokok  ";
        }catch (Exception exception){
            return "CartProduct ko ton tai";
        }
    }

    //miss update cart total
    public CartProduct update(Long cartId, Long productId) {
        CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
        Product product = productRepository.findById(productId).orElse(null);


        if (cartProduct != null && product != null) {
            cartProduct.setQuantity(cartProduct.getQuantity() + 1);
        } else {
            cartProduct = new CartProduct();
            cartProduct.setCartId(cartId);
            cartProduct.setProductId(productId);
            cartProduct.setQuantity(1);
        }   return cartProductRepository.save(cartProduct);
    }
}
