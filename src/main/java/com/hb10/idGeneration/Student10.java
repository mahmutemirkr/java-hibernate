package com.hb10.idGeneration;

import javax.persistence.*;

@Entity
public class Student10 {

    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "sequence",
            sequenceName = "student_seq",
            initialValue = 1000,
            allocationSize = 10
    )
    @Id
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;


    // Getter -Setter


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // toSting()

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
