package com.example.library.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BookDto {
    private Long id;
    private String title;
    private Integer year;
    private String publishing;
    private Set<AuthorDto> authors = new HashSet<>();

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

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) && Objects.equals(title, bookDto.title) && Objects.equals(year, bookDto.year) && Objects.equals(publishing, bookDto.publishing) && Objects.equals(authors, bookDto.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, publishing, authors);
    }

}
