package com.arturocastro.apisb.repository;

import com.arturocastro.apisb.entitie.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
