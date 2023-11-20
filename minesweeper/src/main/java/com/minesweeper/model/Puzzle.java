package com.minesweeper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "puzzle")
public class Puzzle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private int mines;

    @Lob
    @Column(nullable = false)
    private String layout;

    // Constructors, getters, setters, and other methods

    public Puzzle() {
    }



}
