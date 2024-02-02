package com.minesweeper.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "solve")
@IdClass(SolveId.class)
public class Solve {
    @Id
    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Puzzle puzzle;

    @Column
    private java.sql.Time time; // Using java.sql.Time for TIME data type

    // Constructors, getters, setters, and other methods

    public Solve() {
    }

    public Solve(User user, Puzzle puzzle, Time time) {
        this.user = user;
        this.puzzle = puzzle;
        this.time = time;
    }

    public User getPlayer() {
        return user;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public Time getTime() {
        return time;
    }

    public void setPlayer(User user) {
        this.user = user;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
