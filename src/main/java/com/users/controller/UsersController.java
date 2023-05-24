package com.users.controller;

import com.users.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @GetMapping("/users")
    public List<Object> getUsersList() {
        return List.of(new User("Ivan", 29), new User("Dmytro", 31));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = new User("Ivan", 29);
        return ResponseEntity.ok(user);
    }

}
