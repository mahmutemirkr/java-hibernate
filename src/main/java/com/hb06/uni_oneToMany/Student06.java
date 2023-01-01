package com.hb06.uni_oneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {

    @Id
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String studentNames;

    private int grade;

    @OneToMany
    @JoinColumn
    private List<Book06> bookList = new ArrayList<>();

    //Getter - Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(String studentNames) {
        this.studentNames = studentNames;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList() {
        this.bookList = bookList;
    }

    public void setBookList(Long id, String bookName) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", studentNames='" + studentNames + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
