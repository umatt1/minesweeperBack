package com.minesweeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
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

    public Puzzle createPuzzleOfTheDay() {
        Puzzle puzzle = new Puzzle();

        // Set the date to the current date
        puzzle.setDate(new Date());

        // Your logic to generate the layout for the puzzle
        // For example, you can call a method to generate a random layout
        List<List<Integer>> layout = generateRandomLayout();
        puzzle.setLayout(layout);

        // Save the puzzle to the database
        return puzzleRepository.save(puzzle);
    }

    public Optional<Puzzle> getPuzzleByDate(LocalDate date) {
        return puzzleRepository.findByDate(date);
    }
}
