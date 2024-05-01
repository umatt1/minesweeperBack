package com.minesweeper.controller;

import com.minesweeper.model.Solve;
import com.minesweeper.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")

@RequestMapping("/solve")
public class SolveController {

    @Autowired
    private SolveService solveService;

    @GetMapping
    public List<Solve> getAllSolves() {
        return solveService.getAllSolves();
    }

    @PostMapping
    public Solve createSolve(@RequestBody Solve solve) {
        return solveService.createSolve(solve);
    }

    @GetMapping("/{solveId}")
    public Optional<Solve> getSolveById(@PathVariable Long solveId) {
        return solveService.getSolveById(solveId);
    }

    @GetMapping("/{user}")
    public List<Solve> getSolvesForWeek(@PathVariable String user) {
        return solveService.getSolvesForWeek(user);
    }

}
