
package com.example.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saved_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date savedDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "grade", nullable = false)
    private int grade; // Grades will be on a scale of 1-5

    @PrePersist
    public void prePersist() {
        this.savedDate = new java.util.Date();
    }

    public Exam() {}

    public Exam(Student student, int grade) {
        this.student = student;
        this.grade = grade;
    }

    // Getters and Setters
    public java.util.Date getSavedDate() {
        return this.savedDate;
    }
    public Integer getGrade() {
        return this.grade;
    }
}
