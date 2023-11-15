package com.minesweeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minesweeper.model.Player;
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // You can add custom query methods here if needed
}
