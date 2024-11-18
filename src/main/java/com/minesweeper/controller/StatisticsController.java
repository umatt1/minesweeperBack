package com.minesweeper.controller;

import com.minesweeper.service.UserService;
import com.minesweeper.service.SolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private UserService userService;

    @Autowired
    private SolveService solveService;

    @GetMapping("/users/total")
    public ResponseEntity<Long> getTotalUsers() {
        return ResponseEntity.ok(userService.getTotalUsers());
    }

    @GetMapping("/solves/total")
    public ResponseEntity<Long> getTotalSolves() {
        return ResponseEntity.ok(solveService.getTotalSolves());
    }
}
