package com.minesweeper.controller;


import com.minesweeper.service.PlayerService;
import com.minesweeper.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// SolveController.java
@RestController
@RequestMapping("/solves")
public class SolveController {
    @Autowired
    private SolveService solveService;

    // CRUD operations for Solve entity
}