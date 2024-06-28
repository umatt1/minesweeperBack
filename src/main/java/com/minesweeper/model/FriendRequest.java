package com.minesweeper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "friend_request")
@IdClass(FriendRequestId.class)
public class FriendRequest {

    @Id
    @Column(nullable = false)
    private String requester;

    @Id
    @Column(nullable = false)
    private String requested;

    @Column(length = 20, nullable = false)
    private String status = "pending";

    // Default constructor
    public FriendRequest() {}

    // Parameterized constructor
    public FriendRequest(String requester, String requested, String status) {
        this.requester = requester;
        this.requested = requested;
        this.status = status;
    }

    // Getters and setters
    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "FriendRequest{" +
                "requester='" + requester + '\'' +
                ", requested='" + requested + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
