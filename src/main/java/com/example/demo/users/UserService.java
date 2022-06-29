package com.example.demo.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getUsers () {
        return userRepository.findAll();
    }

    public List<Users> getUser (Long userId) {
        return userRepository.findAllById(Collections.singleton(userId));
    }

    public List<Users> getUserByName (String userName) {
        return userRepository.findUserBYname(userName);
    }

    public List<Users> addNewUser(Users users) {
        Optional<Users> userOptional = userRepository.findUserBYEmail(users.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(users);
        return getUser(users.getId());
    }

    public List<Users> deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("user with id " + userId + "does not exists");

        }
        userRepository.deleteById(userId);
        return getUsers();
    }

    @Transactional
    public void updateUser(Long userId, String name, String email) {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with id " + userId + "does not exists")
                );
        if (name != null && name.length() > 0 && !Objects.equals(users.getName(), name)) {
            users.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(users.getEmail(), email)) {
            Optional<Users> userOptional = userRepository.findUserBYEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            users.setEmail(email);
        }

    }
}
