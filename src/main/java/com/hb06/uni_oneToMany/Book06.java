package com.hb06.uni_oneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book06 {

    @Id
    private Long id;

    private String bookName;

    //Getter - Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
