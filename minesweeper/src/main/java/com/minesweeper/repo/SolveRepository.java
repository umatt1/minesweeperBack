package com.minesweeper.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolveRepository extends JpaRepository<Solve, Long> {
    // You can add custom query methods here if needed
}
