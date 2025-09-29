package com.arturocastro.apisb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User extends MongoRepository<User, Long> {
    User findByEmail(String email);
}
