package com.arturocastro.apisb.entitie;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "products")
public class Product {
    @Id
    private String id;

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "La descripción es requerida")
    private String description;

    @NotBlank(message = "El precio es requerido")
    private Double price;

    @NotBlank(message = "Las imagenes del producto son requeridas")
    private List<String> images;

    public Product() {
    }

    public Product(String id, String name, String description, Double price, List<String> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
