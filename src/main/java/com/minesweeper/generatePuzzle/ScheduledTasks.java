package com.minesweeper.generatePuzzle;

import com.minesweeper.controller.PuzzleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    PuzzleController puzzleController;

    @Scheduled(cron = "0 0 0 * * ?") // Run at midnight every night
    public void createPuzzle() {
        puzzleController.createPuzzleOfTheDay();
    }
}
