package com.minesweeper.controller;


import com.minesweeper.service.PlayerService;
import com.minesweeper.service.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// PuzzleController.java
@RestController
@RequestMapping("/puzzles")
public class PuzzleController {
    @Autowired
    private PuzzleService puzzleService;

    // CRUD operations for Puzzle entity
}