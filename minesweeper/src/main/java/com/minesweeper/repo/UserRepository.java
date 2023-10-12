package com.minesweeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minesweeper.model.User;
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed
}
