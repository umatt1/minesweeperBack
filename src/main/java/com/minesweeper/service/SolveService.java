package com.minesweeper.service;

import com.minesweeper.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.minesweeper.repo.SolveRepository;
import com.minesweeper.model.Solve;

@Service
public class SolveService {

    private final SolveRepository solveRepository;

    private final UserService userService;

    @Autowired
    public SolveService(SolveRepository solveRepository, UserService userService) {
        this.solveRepository = solveRepository;
        this.userService = userService;
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

    public List<Solve> getSolvesForWeek(String user) {
        LocalDate startOfWeek = LocalDate.now();
        while(!startOfWeek.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            startOfWeek = startOfWeek.minusDays(1);
        }
        return solveRepository.getSolvesForWeek(user, startOfWeek);
    }

}
