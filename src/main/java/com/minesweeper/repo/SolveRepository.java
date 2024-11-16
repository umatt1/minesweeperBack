package com.minesweeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minesweeper.model.Solve;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SolveRepository extends JpaRepository<Solve, Long> {

    @Query("SELECT s FROM Solve s WHERE s.user.username = ?1 AND s.puzzle.id IN (SELECT p.id FROM Puzzle p WHERE p.date >= ?2)")
    List<Solve> getSolvesForWeek(String user, LocalDate date);

    // In SolveRepository.java
    @Query("SELECT s FROM Solve s WHERE s.puzzle.id = ?1 AND s.user.username IN ?2")
    List<Solve> findByPuzzleIdAndUserUsernameIn(Long puzzleId, List<String> friends);

}
