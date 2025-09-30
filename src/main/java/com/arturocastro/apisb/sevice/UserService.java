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
        if (user.getId() != null) {
            throw new IllegalArgumentException("El ID no debe enviarse, Mongo lo genera automáticamente");
        }
        // Aquí podrías validar por email, por ejemplo
        if (userRepository.findAll().stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()))) {
            throw new IllegalArgumentException("Ya existe un usuario con ese email");
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
