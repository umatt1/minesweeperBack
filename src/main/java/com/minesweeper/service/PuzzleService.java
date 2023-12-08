package com.minesweeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.minesweeper.repo.PuzzleRepository;
import com.minesweeper.model.Puzzle;

@Service
public class PuzzleService {

    private final PuzzleRepository puzzleRepository;

    @Autowired
    public PuzzleService(PuzzleRepository puzzleRepository) {
        this.puzzleRepository = puzzleRepository;
    }

    public List<Puzzle> getAllPuzzles() {
        return puzzleRepository.findAll();
    }

    public Optional<Puzzle> getPuzzleById(Long puzzleId) {
        return puzzleRepository.findById(puzzleId);
    }

    public Puzzle createPuzzle(Puzzle puzzle) {
        return puzzleRepository.save(puzzle);
    }

    public void deletePuzzle(Long puzzleId) {
        puzzleRepository.deleteById(puzzleId);
    }

    // You can add additional methods as needed
    private List<Integer> generateRandomLayout() {
        List<Integer> flattenedLayout = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // 0 represents an empty cell, 1 represents a mine
                flattenedLayout.add(random.nextInt(2));
            }
        }

        return flattenedLayout;
    }
    public Puzzle createPuzzleOfTheDay() {
        List<Integer> layout = generateRandomLayout();

        // Create puzzle
        Puzzle puzzle = new Puzzle(LocalDate.now(), layout, 10L, 10L);

        // Save the puzzle to the database
        return puzzleRepository.save(puzzle);
    }

    public Optional<Puzzle> getPuzzleByDate(LocalDate date) {
        return puzzleRepository.findByDate(date);
    }
}
