package com.minesweeper.service;

import com.minesweeper.model.FriendRequest;
import com.minesweeper.model.FriendRequestId;
import com.minesweeper.model.User;
import com.minesweeper.repo.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class FriendRequestService {

    private final TokenService tokenService;
    private final FriendRequestRepository friendRequestRepository;

    @Autowired
    public FriendRequestService(TokenService tokenService, FriendRequestRepository friendRequestRepository) {
        this.tokenService = tokenService;
        this.friendRequestRepository = friendRequestRepository;
    }

    // Request a friend
    public FriendRequest requestFriend(String requester, String requested, String jwtToken) throws AuthenticationException {
        // Verify the JWT token
        if (!this.tokenService.verifyJwtForUser(jwtToken, requester)) {
            throw new AuthenticationException("Invalid JWT");
        }

        // Check if a friendship already exists
        if (this.friendRequestRepository.existsFriendship(requester, requested)) {
            throw new RuntimeException("Friend request not unique");
        }

        // Create and save the friend request
        FriendRequest friendRequest = new FriendRequest(requester, requested, "pending");
        return friendRequestRepository.save(friendRequest);
    }

    // Accept a friend request
    public FriendRequest acceptFriendRequest(String requester, String requested, String jwtToken) throws AuthenticationException {
        // Verify the JWT token
        if (!this.tokenService.verifyJwtForUser(jwtToken, requested)) {
            throw new AuthenticationException("Invalid JWT");
        }

        // Find the friend request
        Optional<FriendRequest> friendRequestOptional = friendRequestRepository.findById(new FriendRequestId(requester, requested));
        if (friendRequestOptional.isPresent()) {
            FriendRequest friendRequest = friendRequestOptional.get();
            friendRequest.setStatus("accepted");
            return friendRequestRepository.save(friendRequest);
        } else {
            throw new RuntimeException("Friend request not found.");
        }
    }

    // Reject a friend request
    public void rejectFriendRequest(String requester, String requested, String jwtToken) throws AuthenticationException {
        // Verify the JWT token
        if (!this.tokenService.verifyJwtForUser(jwtToken, requested)) {
            throw new AuthenticationException("Invalid JWT");
        }

        // Find and delete the friend request
        Optional<FriendRequest> friendRequestOptional = friendRequestRepository.findById(new FriendRequestId(requester, requested));
        friendRequestOptional.ifPresent(friendRequestRepository::delete);
    }

    // Get all friend requests sent by a user
    public List<FriendRequest> getFriendRequestsSentByUser(String requester, String jwtToken) throws AuthenticationException {
        // Verify the JWT token
        if (!this.tokenService.verifyJwtForUser(jwtToken, requester)) {
            throw new AuthenticationException("Invalid JWT");
        }

        return friendRequestRepository.findByRequester(requester);
    }

    // Get all friend requests received by a user
    public List<FriendRequest> getFriendRequestsReceivedByUser(String requested, String jwtToken) throws AuthenticationException {
        // Verify the JWT token
        if (!this.tokenService.verifyJwtForUser(jwtToken, requested)) {
            throw new AuthenticationException("Invalid JWT");
        }

        return friendRequestRepository.findByRequested(requested);
    }

    // Get all friend requests between two users
    public List<FriendRequest> getFriendRequestsBetweenUsers(String user1, String user2, String jwtToken) throws AuthenticationException {
        // Verify the JWT token for both users
        if (!this.tokenService.verifyJwtForUser(jwtToken, user1) && !this.tokenService.verifyJwtForUser(jwtToken, user2)) {
            throw new AuthenticationException("Invalid JWT");
        }

        return friendRequestRepository.findFriendRequestsBetweenUsers(user1, user2);
    }

    // Get all friend requests with a specific status
    public List<FriendRequest> getFriendRequestsByStatus(String status, String jwtToken, String username) throws AuthenticationException {
        // Verify the JWT token
        if (!this.tokenService.verifyJwtForUser(jwtToken, username)) {
            throw new AuthenticationException("Invalid JWT");
        }

        return friendRequestRepository.findByStatus(status);
    }

    // Check if any friend request exists between two users
    public boolean anyFriendRequestByUsername(String user1, String user2) {
        return friendRequestRepository.existsFriendship(user1, user2);
    }

    // Check if a friend request has been accepted
    public boolean checkAcceptedFriendByUsername(String user1, String user2, String jwtToken) throws AuthenticationException {
        // Verify the JWT token
        if (!this.tokenService.verifyJwtForUser(jwtToken, user1) && !this.tokenService.verifyJwtForUser(jwtToken, user2)) {
            throw new AuthenticationException("Invalid JWT");
        }

        List<FriendRequest> friendRequests = friendRequestRepository.findFriendRequestsBetweenUsers(user1, user2);
        return friendRequests.stream().anyMatch(fr -> "accepted".equals(fr.getStatus()));
    }
}
