package com.minesweeper.model;

import java.io.Serializable;
import java.util.Objects;

public class FriendRequestId implements Serializable {
    private String requester;
    private String requested;

    // Default constructor
    public FriendRequestId() {}

    // Parameterized constructor
    public FriendRequestId(String requester, String requested) {
        this.requester = requester;
        this.requested = requested;
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

    // hashCode and equals methods
    @Override
    public int hashCode() {
        return Objects.hash(requester, requested);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FriendRequestId that = (FriendRequestId) obj;
        return Objects.equals(requester, that.requester) && Objects.equals(requested, that.requested);
    }
}
