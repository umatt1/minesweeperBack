package com.minesweeper.controller;

import com.minesweeper.model.*;
import com.minesweeper.service.FriendRequestService;
import com.minesweeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.naming.AuthenticationException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendRequestService friendRequestService;

    @PostMapping("/request")
    public ResponseEntity<FriendRequest> requestFriend(@RequestBody FriendRequestDTO friendRequest) throws AuthenticationException {
        return ResponseEntity.ok(friendRequestService.requestFriend(friendRequest.getRequester(),friendRequest.getRequested(), friendRequest.getJwt()));
    }

    @PutMapping("/request/respond")
    public ResponseEntity<FriendRequestResponseDTO> respondToRequest(@RequestBody FriendRequestResponseDTO friendRequest) {
        return ResponseEntity.ok(friendRequest);
    }

    @GetMapping("/request/{username}")
    public ResponseEntity<List<FriendRequest>> getRequests(@PathVariable String username) {
        return ResponseEntity.ok(new ArrayList<>());
    }



}
