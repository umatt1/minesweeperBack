package com.minesweeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minesweeper.model.Puzzle;

public interface PuzzleRepository extends JpaRepository<Puzzle, Long> {
    // You can add custom query methods here if needed
}
