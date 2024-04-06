package com.minesweeper.controller;

import com.minesweeper.controller.PuzzleController;
import com.minesweeper.model.Puzzle;
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
class PuzzleControllerTest {

//    @Mock
//    private PuzzleService puzzleService;

//    @InjectMocks
//    private PuzzleController puzzleController;

//    @Test
//    void getAllPuzzles() {
//        // Mock the behavior of the service
//        List<Puzzle> puzzles = Arrays.asList(new Puzzle(), new Puzzle());
//        Mockito.when(puzzleService.getAllPuzzles()).thenReturn(puzzles);
//
//        // Call the controller method
//        //List<Puzzle> result = puzzleController.getAllPuzzles();
//
//        // Verify the result
//        //assertEquals(puzzles, result);
//    }
//
//    @Test
//    void getPuzzleById() {
//        // Mock the behavior of the service
//        Puzzle puzzle = new Puzzle();
//        Mockito.when(puzzleService.getPuzzleById(1L)).thenReturn(Optional.of(puzzle));
//
//        // Call the controller method
//        //Optional<Puzzle> result = puzzleController.getPuzzleById(1L);
//
//        // Verify the result
//        //assertEquals(Optional.of(puzzle), result);
//    }
//
//    @Test
//    void createPuzzle() {
//        // Mock the behavior of the service
//        Puzzle puzzle = new Puzzle();
//        Mockito.when(puzzleService.createPuzzle(any(Puzzle.class))).thenReturn(puzzle);
//
//        // Call the controller method
//        //Puzzle result = puzzleController.createPuzzle(puzzle);
//
//        // Verify the result
//        //assertEquals(puzzle, result);
//    }
//
//    @Test
//    void deletePuzzle() {
//        // Call the controller method
//        puzzleController.deletePlayer(1L);
//
//        // Verify that the service method was called once with the correct argument
//        Mockito.verify(puzzleService, times(1)).deletePuzzle(1L);
//    }
//
//    @Test
//    void deleteNonexistentPuzzle() {
//        // Mock the behavior of the service to throw an exception
//        Mockito.doThrow(new IllegalArgumentException("Puzzle not found")).when(puzzleService).deletePuzzle(1L);
//
//        // Call the controller method and expect an exception
//        assertThrows(IllegalArgumentException.class, () -> puzzleController.deletePlayer(1L));
//    }
}
