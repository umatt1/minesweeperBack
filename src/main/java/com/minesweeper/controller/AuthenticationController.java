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
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
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
