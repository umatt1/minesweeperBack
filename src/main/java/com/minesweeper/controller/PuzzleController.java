package com.minesweeper.controller;

import com.minesweeper.model.Puzzle;
import com.minesweeper.service.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/puzzles")
public class PuzzleController {
    @Autowired
    private PuzzleService puzzleService;

    // CRUD operations for Puzzle entity

    @GetMapping
    public ResponseEntity<List<Puzzle>> getAllPuzzles() {
        List<Puzzle> puzzles = puzzleService.getAllPuzzles();
        return new ResponseEntity<>(puzzles, HttpStatus.OK);
    }

    @GetMapping("/{puzzleId}")
    public ResponseEntity<Puzzle> getPuzzleById(@PathVariable Long puzzleId) {
        Optional<Puzzle> puzzle = puzzleService.getPuzzleById(puzzleId);
        return puzzle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Puzzle> createPuzzle(@RequestBody Puzzle puzzle) {
        Puzzle createdPuzzle = puzzleService.createPuzzle(puzzle);
        return new ResponseEntity<>(createdPuzzle, HttpStatus.CREATED);
    }

    @DeleteMapping("/{puzzleId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long puzzleId) {
        puzzleService.deletePuzzle(puzzleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/createPuzzleOfTheDay")
    public ResponseEntity<Puzzle> createPuzzleOfTheDay() {
        // Create a puzzle with the day set to the current date
        Puzzle createdPuzzle = puzzleService.createPuzzleOfTheDay();
        return new ResponseEntity<>(createdPuzzle, HttpStatus.CREATED);
    }

    // Endpoint to get the puzzle for a given date
    @GetMapping("/getPuzzleByDate")
    public ResponseEntity<Puzzle> getPuzzleByDate(@RequestParam(required = false)
                                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }

        Optional<Puzzle> puzzle = puzzleService.getPuzzleByDate(date);
        return puzzle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
