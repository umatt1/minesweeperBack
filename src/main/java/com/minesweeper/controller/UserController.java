package com.minesweeper.controller;

import com.minesweeper.model.User;
import com.minesweeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/players")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }

    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
//        Optional<User> user = userService.getPlayerById(userId);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

//    @PostMapping
//    public ResponseEntity<Object> createUser(@RequestBody User user) {
//        try {
//            User createdUser = userService.createPlayer(user);
//            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                    .buildAndExpand(createdUser.getEmail()).toUri();
//            return ResponseEntity.created(location).build();
//        } catch (RuntimeException e) {
//            // Handle the exception, e.g., duplicate username or email
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
//    }

//    @DeleteMapping("/{playerId}")
//    public void deleteUser(@PathVariable Long userId) {
//        userService.deletePlayer(userId);
//    }


}
