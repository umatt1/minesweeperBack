package com.minesweeper.controller;

import com.minesweeper.model.Solve;
import com.minesweeper.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/solve")
public class SolveController {

    @Autowired
    private SolveService solveService;

    @GetMapping
    public List<Solve> getAllSolves() {
        return solveService.getAllSolves();
    }

    @GetMapping("/{solveId}")
    public Optional<Solve> getSolveById(@PathVariable Long solveId) {
        return solveService.getSolveById(solveId);
    }

    @PostMapping
    public Solve createSolve(@RequestBody Solve solve) {
        return solveService.createSolve(solve);
    }

    @DeleteMapping("/{solveId}")
    public void deleteSolve(@PathVariable Long solveId) {
        solveService.deleteSolve(solveId);
    }

    // You can add additional methods as needed
}
