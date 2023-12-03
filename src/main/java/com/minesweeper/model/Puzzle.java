package com.minesweeper.model;

import jakarta.persistence.*;

import java.util.Date;
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
    private Date date;

    @Lob
    @Column(nullable = true)
    public Date getDate() {
        return date;
    }

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
