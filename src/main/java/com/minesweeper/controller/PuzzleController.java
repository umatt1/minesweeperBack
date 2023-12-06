package com.minesweeper.controller;

import com.minesweeper.model.Puzzle;
import com.minesweeper.service.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// PuzzleController.java
@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping("/createPuzzleOfTheDay")
    public Puzzle createPUzzleOfTheDay() {
        //Create a puzzle with the day set to the current date
        Puzzle puzzleOfTheDay = puzzleService.createPuzzleOfTheDay();
        return puzzleOfTheDay;
    }

    // Endpoint to get the puzzle for a given date
    @GetMapping("/getPuzzleByDate")
    public Optional<Puzzle> getPuzzleByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return puzzleService.getPuzzleByDate(date);
    }
}