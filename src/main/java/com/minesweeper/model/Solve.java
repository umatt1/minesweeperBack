package com.minesweeper.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "solve")
@IdClass(SolveId.class)
public class Solve {
    @Id
    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "id")
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Puzzle puzzle;

    @Column
    private java.sql.Time time; // Using java.sql.Time for TIME data type

    // Constructors, getters, setters, and other methods

    public Solve() {
    }

    public Solve(Player player, Puzzle puzzle, Time time) {
        this.player = player;
        this.puzzle = puzzle;
        this.time = time;
    }

    public Player getPlayer() {
        return player;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public Time getTime() {
        return time;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
