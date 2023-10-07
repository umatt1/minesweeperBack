package com.minesweeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SolveService {

    private final SolveRepository solveRepository;

    @Autowired
    public SolveService(SolveRepository solveRepository) {
        this.solveRepository = solveRepository;
    }

    public List<Solve> getAllSolves() {
        return solveRepository.findAll();
    }

    public Optional<Solve> getSolveById(Long solveId) {
        return solveRepository.findById(solveId);
    }

    public Solve createSolve(Solve solve) {
        return solveRepository.save(solve);
    }

    public void deleteSolve(Long solveId) {
        solveRepository.deleteById(solveId);
    }

    // You can add additional methods as needed
}
