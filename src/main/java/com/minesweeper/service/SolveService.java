package com.minesweeper.service;

import com.minesweeper.model.SolveDTO;
import com.minesweeper.model.User;
import com.minesweeper.repo.PuzzleRepository;
import com.minesweeper.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import com.minesweeper.repo.SolveRepository;
import com.minesweeper.model.Solve;

@Service
public class SolveService {

    private final SolveRepository solveRepository;
    private final PuzzleRepository puzzleRepository;
    private final UserRepository userRepository;

    @Autowired
    public SolveService(SolveRepository solveRepository, PuzzleRepository puzzleRepository, UserRepository userRepository) {
        this.solveRepository = solveRepository;
        this.puzzleRepository = puzzleRepository;
        this.userRepository = userRepository;
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

    public Solve createSolve(SolveDTO solve) {
        Solve solved = new Solve();
        // Convert seconds string to double
        double seconds = Double.parseDouble(solve.getTime());
        // Convert seconds to milliseconds
        long milliseconds = (long) (seconds * 1000);
        // Convert milliseconds to LocalTime
        LocalTime time = LocalTime.ofNanoOfDay(milliseconds * 1_000_000);
        // Convert LocalTime to Time (java.sql.Time)
        solved.setTime(Time.valueOf(time));

        solved.setPuzzle(puzzleRepository.findById(Long.parseLong(solve.getPuzzleId())).get());
        solved.setPlayer(userRepository.findByUsername(solve.getUsername()).get());
        solved.setSuccess(solve.getSuccess());
        return solveRepository.save(solved);
    }

    public List<Solve> getSolvesForWeek(String user) {
        LocalDate startOfWeek = LocalDate.now();
        while(!startOfWeek.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            startOfWeek = startOfWeek.minusDays(1);
        }
        return solveRepository.getSolvesForWeek(user, startOfWeek);
    }

    // In SolveService.java
    public List<Solve> getSolvesForFriends(List<String> friends, Long puzzleId) {
        return solveRepository.findByPuzzleIdAndUserUsernameIn(puzzleId, friends);
    }

    public long getTotalSolves() {
        return solveRepository.count();
    }
}
