package com.minesweeper.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "puzzle")
public class Puzzle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    public Long getId() {
        return id;
    }

    @Lob
    @Column(nullable = true)
    private LocalDate date;

    @Lob
    @Column(nullable = true)
    public LocalDate getDate() {
        return date;
    }

    @Lob
    @Column(nullable = false)
    private List<Integer> layout;

    @Column(nullable = false)
    public List<Integer> getLayout() {
        return layout;
    }

    @Column(nullable = false)
    public void setLayout(List<Integer> layout) {
        this.layout = layout;
    }

    // Constructors, getters, setters, and other methods

    public Puzzle() {
    }

    public Puzzle(LocalDate date, List<Integer> layout) {
        this.date = date;
        this.layout = layout;
    }
}
