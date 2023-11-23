package com.minesweeper.controller;

import com.minesweeper.model.Puzzle;
import com.minesweeper.service.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// PuzzleController.java
@RestController
@RequestMapping("/puzzles")
public class PuzzleController {
    @Autowired
    private PuzzleService puzzleService;

    // CRUD operations for Puzzle entity

    @GetMapping
    public List<Puzzle> getAllPuzzles() {
        return puzzleService.getAllPuzzles();
    }

    @GetMapping("/{puzzleId}")
    public Optional<Puzzle> getPuzzleById(@PathVariable Long puzzleId) {
        return puzzleService.getPuzzleById(puzzleId);
    }

    @PostMapping
    public Puzzle createPuzzle(@RequestBody Puzzle puzzle) {
        return puzzleService.createPuzzle(puzzle);
    }

    @DeleteMapping("/{puzzleId}")
    public void deletePlayer(@PathVariable Long puzzleId) {
        puzzleService.deletePuzzle(puzzleId);
    }
}