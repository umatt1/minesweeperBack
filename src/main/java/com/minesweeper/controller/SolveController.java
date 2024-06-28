package com.minesweeper.controller;

import com.minesweeper.model.Solve;
import com.minesweeper.model.SolveDTO;
import com.minesweeper.service.SolveService;
import com.minesweeper.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solve")
public class SolveController {

    @Autowired
    private SolveService solveService;

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public List<Solve> getAllSolves() {
        return solveService.getAllSolves();
    }

    @PostMapping
    public Solve createSolve(@RequestBody SolveDTO solve) {
        if (tokenService.verifyJwtForUser(solve.getJwt(), solve.getUsername())) {
            return solveService.createSolve(solve);
        }
        return new Solve();
    }

    @GetMapping("/id/{solveId}")
    public Optional<Solve> getSolveById(@PathVariable Long solveId) {
        return solveService.getSolveById(solveId);
    }

    @GetMapping("/{user}")
    public List<Solve> getSolvesForWeek(@PathVariable String user) {
        return solveService.getSolvesForWeek(user);
    }

}
