package com.arturocastro.apisb.controller;

import com.arturocastro.apisb.entitie.Product;
import com.arturocastro.apisb.sevice.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public ResponseEntity<Optional<List<Product>>> getAll(){
        Optional <List<Product>> products = Optional.ofNullable(productService.findAll());
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

}
