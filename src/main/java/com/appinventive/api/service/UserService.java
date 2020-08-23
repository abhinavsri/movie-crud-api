package com.appinventive.api.service;

import com.appinventive.api.domain.User;
import com.appinventive.api.exception.UserNotFoundException;
import com.appinventive.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            return userRepository.save(existingUser);

        }
        throw new UserNotFoundException("User not found for this id"+id);
    }
}
