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
        
        // Get current day of week (1 = Monday, 7 = Sunday)
        int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
        // Convert to 0 = Sunday, 6 = Saturday for easier understanding
        dayOfWeek = (dayOfWeek % 7);
        
        // Base size starts small and increases slightly through the week
        // Sunday: 6x6, Monday: 7x7, ..., Saturday: 9x9
        int size = 6 + (dayOfWeek);
        int totalCells = size * size;
        
        // Number of mines increases with difficulty
        // Sunday: 5 mines (13.8%), Monday: 7 mines (14.3%), ..., Saturday: 15 mines (18.5%)
        int numMines = switch(dayOfWeek) {
            case 0 -> 5;  // Sunday
            case 1 -> 7;  // Monday
            case 2 -> 8;  // Tuesday
            case 3 -> 10; // Wednesday
            case 4 -> 12; // Thursday
            case 5 -> 13; // Friday
            case 6 -> 15; // Saturday
            default -> 10;
        };
        
        Set<Integer> mines = new HashSet<>();

        // choose mines
        for (int i = 0; i < numMines; i++) {
            int indexToSwap = random.nextInt(totalCells);
            while(mines.contains(indexToSwap)) {
                indexToSwap = random.nextInt(totalCells);
            }
            mines.add(indexToSwap);
        }

        for (int i = 0; i < totalCells; i++) {
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

        // Get current day of week (1 = Monday, 7 = Sunday)
        int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();
        // Convert to 0 = Sunday, 6 = Saturday for easier understanding
        dayOfWeek = (dayOfWeek % 7);
        
        // Base size starts small and increases slightly through the week
        int size = 6 + (dayOfWeek);
        
        List<Integer> layout = generateRandomLayout();

        // Create puzzle with dynamic size
        Puzzle puzzle = new Puzzle(LocalDate.now(), layout, (long)size, (long)size);

        // Save the puzzle to the database
        return puzzleRepository.save(puzzle);
    }

    public Optional<Puzzle> getPuzzleByDate(LocalDate date) {
        return puzzleRepository.findByDate(date);
    }
}
