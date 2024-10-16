package com.example.demo.service;

import com.example.demo.enums.Roles;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User createUser(String name, String password){
        User user = new User(name,passwordEncoder.encode(password), Roles.USER.name());
        user = userRepository.save(user);
        return user;
    }

    public User createAdmin(String name, String password){
        User user = new User(name,passwordEncoder.encode(password), Roles.ADMIN.name());
        user = userRepository.save(user);
        return user;
    }

    public Optional<User> findUserByUserName(String username){
        return userRepository.findUserByName(username);
    }
}
