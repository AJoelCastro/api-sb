package com.arturocastro.apisb.sevice;

import com.arturocastro.apisb.entitie.User;
import com.arturocastro.apisb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        if (user.getId() != null || verifyExists(user)) {
            return null;
        }
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Boolean verifyExists(User user){
        if(userRepository.findById(user.getId()).isPresent()){
            return true;
        };
        return false;
    }
}
