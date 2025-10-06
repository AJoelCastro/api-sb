package com.arturocastro.apisb.entitie;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String image;
}
