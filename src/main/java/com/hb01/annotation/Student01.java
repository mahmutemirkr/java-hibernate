package com.hb01.annotation;

import javax.persistence.*;

@Entity
@Table(name = "e_student01")
public class Student01 {

    @Id
    private int id;

    @Column(name = "student_name", length = 100, nullable = false, unique = false)
    private String name;

    //@Transient - Prevents it from creating this column in the database, but i want it to be
    private int grade;

    /* @Lob //large object
    private byte[] image; */


    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
