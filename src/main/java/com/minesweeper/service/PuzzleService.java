package com.minesweeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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

    private List<Integer> generateRandomLayout() {
        List<Integer> flattenedLayout = new ArrayList<>();
        Random random = new Random();
        int numMines = 10;
        Set<Integer> mines = new HashSet<>();

        // choose mines
        for (int i = 0; i < numMines; i++) {
            int indexToSwap = random.nextInt(100);
            while(mines.contains(indexToSwap)) {
                indexToSwap = random.nextInt(100);
            }
            mines.add(indexToSwap);
        }

        for (int i = 0; i < 100; i++) {
            if (mines.contains(i)) {
                flattenedLayout.add(1);
            } else {
                flattenedLayout.add(0);
            }
        }


        return flattenedLayout;
    }
    public Puzzle createPuzzleOfTheDay() {

        // don't create another if one already exists
        if (puzzleRepository.findByDate(LocalDate.now()).isPresent()) {
            return puzzleRepository.findByDate(LocalDate.now()).get();
        }

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
