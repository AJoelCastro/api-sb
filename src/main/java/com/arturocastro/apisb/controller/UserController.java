package com.arturocastro.apisb.controller;

import com.arturocastro.apisb.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arturocastro.apisb.entities.User;
import java.util.List;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(User user){
        User userSaved = userRepository.save(user);
        return ResponseEntity.ok().body(userSaved);
    }

    @GetMapping("/users")
    public ResponseEntity<User> getAll(){
        List<User> list = userRepository.findAll();
        if(list.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(list.get(0));
    }
}
