package com.arturocastro.apisb.controller;

import com.arturocastro.apisb.sevice.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

}
