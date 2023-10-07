package com.minesweeper.model;

import javax.persistence.*;

@Entity
@Table(name = "solve")
public class Solve {
    @Id
    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "id")
    private Puzzle puzzle;

    @Column
    private java.sql.Time time; // Using java.sql.Time for TIME data type

    // Constructors, getters, setters, and other methods
}
