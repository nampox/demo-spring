package com.example.demosprinng.controller;

import com.example.demosprinng.entity.CartProduct;
import com.example.demosprinng.entity.Product;
import com.example.demosprinng.repository.CartProductRepository;
import com.example.demosprinng.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cartProduct")
public class CartProductController {
    @Autowired
    CartProductService cartProductService;

    //sai
    @GetMapping(path = "findAllCardProduct")
    public List<CartProduct>findAll(){
        return cartProductService.findAll();
    }
    @PutMapping(path = "updateCartProduct")
    public CartProduct update(@RequestBody Long cartId, Long productId){
        return cartProductService.update(cartId,productId);
    }

    //sai
    @PostMapping(path = "createCartProduct")
    public CartProduct create(@RequestBody CartProduct productCreate){
        return cartProductService.add(productCreate);
    }
    @DeleteMapping(path = "deleteCartProduct")
    public String delete(@RequestParam Long id){
        return cartProductService.delete(id);
    }
}
