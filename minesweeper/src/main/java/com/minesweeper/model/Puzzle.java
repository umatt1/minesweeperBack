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
    private byte[] layout; // You can use a byte array for VARBINARY data

    // Constructors, getters, setters, and other methods

    public Puzzle() {
    }



}
