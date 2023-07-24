package com.example.demosprinng.service;

import com.example.demosprinng.entity.CartProduct;
import com.example.demosprinng.entity.Product;
import com.example.demosprinng.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product add(Product product){
        return productRepository.save(product);
    }
    public Product delete(Long id){

            Product product = productRepository.findById(id).get();
            productRepository.delete(product);
            return product;

    }
    public Product update(Product update){
        Product product = productRepository.findById(update.getId()).get();
        product.setName(update.getName());
        product.setQuantity(update.getQuantity());
        product.setPrice(update.getPrice());
        productRepository.save(product);

//        List<Product> productList = productRepository.findAll();
//        for (Product p: productList) {
//        }
//
        return product;
    }

}
