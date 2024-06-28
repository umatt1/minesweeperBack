package com.minesweeper.controller;

import com.minesweeper.model.LoginResponseDTO;
import com.minesweeper.model.RegistrationDTO;
import com.minesweeper.model.User;
import com.minesweeper.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationDTO body) {
        try {
            return new ResponseEntity<User>(authenticationService.registerUser(body.getUsername(), body.getPassword()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new User(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody RegistrationDTO body){
        try {
            return new ResponseEntity<>(authenticationService.loginUser(body.getUsername(), body.getPassword()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new LoginResponseDTO(), HttpStatus.BAD_REQUEST);
        }
    }
}
