package com.arturocastro.apisb.sevice;

import com.arturocastro.apisb.entitie.Product;
import com.arturocastro.apisb.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product){
        if(product.getId() != null){
            throw new IllegalArgumentException("El id no debe enviarse por el cliente, Mongo DB lo generará automaticamente");
        }
        if(productRepository.findAll().stream().anyMatch(p -> p.getName().equalsIgnoreCase(product.getName()))){
            throw new IllegalArgumentException("Ya existe un producto con ese nombre");
        }
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
