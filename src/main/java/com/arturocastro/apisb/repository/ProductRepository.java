package com.arturocastro.apisb.repository;

import com.arturocastro.apisb.entitie.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
