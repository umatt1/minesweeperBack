package com.minesweeper.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "puzzle")
public class Puzzle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true, unique = true)
    private LocalDate date;

    @Column(nullable = false)
    private List<Integer> layout;

    @Column(nullable = false)
    private Long height;

    @Column(nullable = false)
    private Long width;

    @Column(nullable = false)
    private Integer mines;

    @Column(nullable = false)
    public List<Integer> getLayout() {
        return layout;
    }

    public Integer getId() {
        return id;
    }

    @Column(nullable = true)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(nullable = false)
    public Long getHeight() {
        return height;
    }

    @Column(nullable = false)
    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    @Column(nullable = false)
    public void setLayout(List<Integer> layout) {
        this.layout = layout;
    }

    @Column(nullable = false)
    public Integer getMines() {
        return mines;
    }

    public void setMines(Integer mines) {
        this.mines = mines;
    }

    // Constructors, getters, setters, and other methods

    public Puzzle() {
    }

    public Puzzle(LocalDate date, List<Integer> layout, Long height, Long width, Integer mines) {
        this.date = date;
        this.layout = layout;
        this.height = height;
        this.width = width;
        this.mines = mines;
    }
}
