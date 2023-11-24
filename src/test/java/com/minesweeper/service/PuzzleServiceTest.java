package com.minesweeper.service;

import com.minesweeper.model.Puzzle;
import com.minesweeper.repo.PuzzleRepository;
import com.minesweeper.service.PuzzleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@SpringBootTest
class PuzzleServiceTest {

    @Mock
    private PuzzleRepository puzzleRepository;

    @InjectMocks
    private PuzzleService puzzleService;

    @Test
    void getAllPuzzles() {
        // Mock the behavior of the repository
        List<Puzzle> puzzles = Arrays.asList(new Puzzle());
        Mockito.when(puzzleRepository.findAll()).thenReturn(puzzles);

        // Call the service method
        List<Puzzle> result = puzzleService.getAllPuzzles();

        // Verify the result
        assertEquals(puzzles, result);
    }

    @Test
    void getPuzzleById() {
        // Mock the behavior of the repository
        Puzzle puzzle = new Puzzle();
        Mockito.when(puzzleRepository.findById(1L)).thenReturn(Optional.of(puzzle));

        // Call the service method
        Optional<Puzzle> result = puzzleService.getPuzzleById(1L);

        // Verify the result
        assertEquals(Optional.of(puzzle), result);
    }

    @Test
    void createPuzzle() {
        // Mock the behavior of the repository
        Puzzle puzzle = new Puzzle();
        Mockito.when(puzzleRepository.save(any(Puzzle.class))).thenReturn(puzzle);

        // Call the service method
        Puzzle result = puzzleService.createPuzzle(puzzle);

        // Verify the result
        assertEquals(puzzle, result);
    }

    @Test
    void deletePuzzle() {
        // Call the service method
        puzzleService.deletePuzzle(1L);

        // Verify that the repository method was called once with the correct argument
        Mockito.verify(puzzleRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteNonexistentPuzzle() {
        // Mock the behavior of the repository to throw an exception
        Mockito.doThrow(new IllegalArgumentException("Puzzle not found")).when(puzzleRepository).deleteById(1L);

        // Call the service method and expect an exception
        assertThrows(IllegalArgumentException.class, () -> puzzleService.deletePuzzle(1L));
    }
}
