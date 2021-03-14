package com.example.library.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer year;
    private String publishing;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Author> authors = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(year, that.year) && Objects.equals(publishing, that.publishing);
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Author author) {
        authors.add(author);
        author.getBooks().add(this);
    }

    public void deleteAuthor(Author author){
        authors.remove(author);
        author.getBooks().remove(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, publishing);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", publishing='" + publishing + '\'' +
                '}';
    }
}
