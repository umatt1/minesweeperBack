package com.minesweeper.repo;

import com.minesweeper.model.FriendRequest;
import com.minesweeper.model.FriendRequestId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequest, FriendRequestId> {

    // Check if a friendship already exists between two users
    @Query("SELECT CASE WHEN COUNT(fr) > 0 THEN true ELSE false END FROM FriendRequest fr WHERE (fr.requester = :user1 AND fr.requested = :user2) OR (fr.requester = :user2 AND fr.requested = :user1)")
    Boolean existsFriendship(@Param("user1") String user1, @Param("user2") String user2);

    // Find all friend requests sent by a user
    List<FriendRequest> findByRequester(String requester);

    // Find all friend requests received by a user
    List<FriendRequest> findByRequested(String requested);

    // Find all friend requests by status
    List<FriendRequest> findByStatus(String status);

    // Find all friend requests between two users
    @Query("SELECT fr FROM FriendRequest fr WHERE (fr.requester = :user1 AND fr.requested = :user2) OR (fr.requester = :user2 AND fr.requested = :user1)")
    List<FriendRequest> findFriendRequestsBetweenUsers(@Param("user1") String user1, @Param("user2") String user2);
}
