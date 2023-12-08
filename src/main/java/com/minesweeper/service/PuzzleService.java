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
        // Your logic to generate a random layout goes here
        // For example, you can create a 2D array with mine positions

        // This is just a placeholder example, adjust it based on your requirements
        List<List<Integer>> layout = new ArrayList<>();
        List<Integer> flattenedLayout = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                // 0 represents an empty cell, 1 represents a mine
                row.add(random.nextInt(2));
                flattenedLayout.add(random.nextInt(2));
            }
            layout.add(row);
        }

        return flattenedLayout;
    }
    public Puzzle createPuzzleOfTheDay() {

        // Your logic to generate the layout for the puzzle
        // For example, you can call a method to generate a random layout
        List<Integer> layout = generateRandomLayout();

        // Create puzzle
        Puzzle puzzle = new Puzzle(LocalDate.now(), layout);

        // Save the puzzle to the database
        return puzzleRepository.save(puzzle);
    }

    public Optional<Puzzle> getPuzzleByDate(LocalDate date) {
        return puzzleRepository.findByDate(date);
    }
}
