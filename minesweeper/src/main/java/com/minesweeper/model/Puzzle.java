package com.minesweeper.model;

import jakarta.persistence.*;

import java.util.List;

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
    private List<List<Integer>> layout;

    @Lob
    @Column(nullable = false)
    public List<List<Integer>> getLayout() {
        return layout;
    }

    // Constructors, getters, setters, and other methods

    public Puzzle() {
    }



}
