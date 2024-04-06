package com.minesweeper.service;

import com.minesweeper.model.Solve;
import com.minesweeper.repo.SolveRepository;
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
class SolveServiceTest {

//    @Mock
//    private SolveRepository solveRepository;

//    @InjectMocks
//    private SolveService solveService;

//    @Test
//    void getAllSolves() {
//        // Mock the behavior of the repository
//        List<Solve> solves = Arrays.asList(new Solve());
//        Mockito.when(solveRepository.findAll()).thenReturn(solves);
//
//        // Call the service method
//        List<Solve> result = solveService.getAllSolves();
//
//        // Verify the result
//        assertEquals(solves, result);
//    }

//    @Test
//    void getSolveById() {
//        // Mock the behavior of the repository
//        Solve solve = new Solve();
//        Mockito.when(solveRepository.findById(1L)).thenReturn(Optional.of(solve));
//
//        // Call the service method
//        Optional<Solve> result = solveService.getSolveById(1L);
//
//        // Verify the result
//        assertEquals(Optional.of(solve), result);
//    }

//    @Test
//    void createSolve() {
//        // Mock the behavior of the repository
//        Solve solve = new Solve();
//        Mockito.when(solveRepository.save(any(Solve.class))).thenReturn(solve);
//
//        // Call the service method
//        Solve result = solveService.createSolve(solve);
//
//        // Verify the result
//        assertEquals(solve, result);
//    }

//    @Test
//    void deleteSolve() {
//        // Call the service method
//        solveService.deleteSolve(1L);
//
//        // Verify that the repository method was called once with the correct argument
//        Mockito.verify(solveRepository, times(1)).deleteById(1L);
//    }

//    @Test
//    void deleteNonexistentSolve() {
//        // Mock the behavior of the repository to throw an exception
//        Mockito.doThrow(new IllegalArgumentException("Solve not found")).when(solveRepository).deleteById(1L);
//
//        // Call the service method and expect an exception
//        assertThrows(IllegalArgumentException.class, () -> solveService.deleteSolve(1L));
//    }
}
