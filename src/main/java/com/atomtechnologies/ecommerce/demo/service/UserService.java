package com.atomtechnologies.ecommerce.demo.service;


import com.atomtechnologies.ecommerce.demo.domain.User;
import com.atomtechnologies.ecommerce.demo.persistence.UserRepository;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(String name, String email, String profile) {
        User user = User.builder()
                .name(name)
                .email(email)
                .profile(profile)
                .build();
        return userRepository.save(user);
    }
}