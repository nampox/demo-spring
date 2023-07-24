package com.example.demosprinng.controller;

import com.example.demosprinng.entity.Product;
import com.example.demosprinng.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "findAll")
    public List<Product>findAll(){
        return productService.findAll();
    }
    @PutMapping(path = "update")
    public Product update(@RequestBody Product productUpdate){
        return productService.update(productUpdate);
    }
    @PostMapping(path = "create")
    public Product create(@RequestBody Product productCreate){
        return productService.add(productCreate);
    }
    @DeleteMapping(path = "delete")
    public Product delete(@RequestParam Long id){
        return productService.delete(id);
    }
}
