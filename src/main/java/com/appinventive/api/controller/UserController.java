package com.appinventive.api.controller;

import com.appinventive.api.domain.User;
import com.appinventive.api.exception.UserNotFoundException;
import com.appinventive.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable(value="id") Long id) throws UserNotFoundException {
        User user = userService.getUser(id).orElseThrow(()->new UserNotFoundException("User not found for this id"+id));
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("users")
    public User getUser(@Valid @RequestBody User user)  {
        return userService.save(user);
    }

    @PutMapping("users/{id}")
    public User updateUser(@PathVariable(value="id") Long id, @Valid @RequestBody User userDetails) throws UserNotFoundException {
        return userService.updateUser(id,userDetails);
    }
}
