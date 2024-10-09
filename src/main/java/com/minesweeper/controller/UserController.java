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

    @GetMapping("/friends/${username}")
    public ResponseEntity<List<String>> getFriends(@PathVariable String username) throws AuthenticationException {
        return ResponseEntity.ok(friendRequestService.getFriends(username));

    }

        @PostMapping("/request")
    public ResponseEntity<FriendRequest> requestFriend(@RequestBody FriendRequestDTO friendRequest, @RequestHeader("Authorization") String authorizationHeader) throws AuthenticationException {
        String token = authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : null;

        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(friendRequestService.requestFriend(friendRequest.getRequester(),friendRequest.getRequested(), token));
    }

    @PutMapping("/request/respond/accept")
    public ResponseEntity<FriendRequest> acceptRequest(@RequestBody FriendRequestResponseDTO friendRequest, @RequestHeader("Authorization") String authorizationHeader) throws AuthenticationException {
        String token = authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : null;

        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(friendRequestService.acceptFriendRequest(friendRequest.getRequester(), friendRequest.getRequested(), token));
    }

    @PutMapping("/request/respond/decline")
    public ResponseEntity<String> declineRequest(@RequestBody FriendRequestResponseDTO friendRequest, @RequestHeader("Authorization") String authorizationHeader) throws AuthenticationException {
        String token = authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : null;

        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        friendRequestService.rejectFriendRequest(friendRequest.getRequester(), friendRequest.getRequested(), token);

        return ResponseEntity.ok("Declined");
    }

    @GetMapping("/request/{username}")
    public ResponseEntity<List<FriendRequest>> getRequests(@PathVariable String username, @RequestHeader("Authorization") String authorizationHeader) throws AuthenticationException {
        String token = authorizationHeader.startsWith("Bearer ") ? authorizationHeader.substring(7) : null;

        if (token == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return ResponseEntity.ok(friendRequestService.getOpenFriendRequestsReceivedByUser(username, token));
    }


}
