package com.minesweeper.controller;

import com.minesweeper.model.Puzzle;
import com.minesweeper.model.Solve;
import com.minesweeper.model.SolveDTO;
import com.minesweeper.service.FriendRequestService;
import com.minesweeper.service.PuzzleService;
import com.minesweeper.service.SolveService;
import com.minesweeper.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solve")
public class SolveController {

    @Autowired
    private SolveService solveService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PuzzleService puzzleService;

    @Autowired
    private FriendRequestService friendRequestService;

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
    @GetMapping("/dailySolvesForFriends/{username}")
    public List<Solve> getDailySolvesForFriends(@PathVariable String username) {
        // Get the friends of the user
        List<String> friends = friendRequestService.getFriends(username);

        // Get the puzzle of the day
        Optional<Puzzle> puzzleOfDay = puzzleService.getPuzzleByDate(LocalDate.now());

        if (puzzleOfDay.isPresent()) {
            // Get the solves for the friends
            return solveService.getSolvesForFriends(friends, (long) puzzleOfDay.get().getId());
        } else {
            // Return an empty list if no puzzle of the day is found
            return new ArrayList<>();
        }
    }
}
