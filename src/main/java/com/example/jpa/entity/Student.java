package com.example.jpa.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Exam> exams;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return this.name;
    }

    public List<Exam> getExams() {
        return this.exams;
    }
}

