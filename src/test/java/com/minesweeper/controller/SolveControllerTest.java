package com.minesweeper.controller;

import com.minesweeper.controller.SolveController;
import com.minesweeper.model.Solve;
import com.minesweeper.service.SolveService;
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
class SolveControllerTest {
//
//    @Mock
//    private SolveService solveService;
//
//    @InjectMocks
//    private SolveController solveController;
//
//    @Test
//    void getAllSolves() {
//        // Mock the behavior of the service
//        List<Solve> solves = Arrays.asList(new Solve());
//        Mockito.when(solveService.getAllSolves()).thenReturn(solves);
//
//        // Call the controller method
//        List<Solve> result = solveController.getAllSolves();
//
//        // Verify the result
//        assertEquals(solves, result);
//    }
//
//    @Test
//    void getSolveById() {
//        // Mock the behavior of the service
//        Solve solve = new Solve();
//        Mockito.when(solveService.getSolveById(1L)).thenReturn(Optional.of(solve));
//
//        // Call the controller method
//        Optional<Solve> result = solveController.getSolveById(1L);
//
//        // Verify the result
//        assertEquals(Optional.of(solve), result);
//    }
//
//    @Test
//    void createSolve() {
//        // Mock the behavior of the service
//        Solve solve = new Solve();
//        Mockito.when(solveService.createSolve(any(Solve.class))).thenReturn(solve);
//
//        // Call the controller method
//        Solve result = solveController.createSolve(solve);
//
//        // Verify the result
//        assertEquals(solve, result);
//    }
//
//    @Test
//    void deleteSolve() {
//        // Call the controller method
//        solveController.deleteSolve(1L);
//
//        // Verify that the service method was called once with the correct argument
//        Mockito.verify(solveService, times(1)).deleteSolve(1L);
//    }
//
//    @Test
//    void deleteNonexistentSolve() {
//        // Mock the behavior of the service to throw an exception
//        Mockito.doThrow(new IllegalArgumentException("Solve not found")).when(solveService).deleteSolve(1L);
//
//        // Call the controller method and expect an exception
//        assertThrows(IllegalArgumentException.class, () -> solveController.deleteSolve(1L));
//    }
}
