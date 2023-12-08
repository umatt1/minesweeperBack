package com.minesweeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minesweeper.model.Puzzle;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface PuzzleRepository extends JpaRepository<Puzzle, Long> {
    @Query("SELECT p FROM Puzzle p WHERE p.date = :date")
    Optional<Puzzle> findByDate(LocalDate date);
}
