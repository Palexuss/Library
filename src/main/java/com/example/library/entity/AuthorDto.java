package com.example.library.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AuthorDto {

    private Long id;
    private String name;
    private String surname;
    private Integer day;
    private Integer month;
    private Integer year;
    private String gender;
    private Set<BookDto> books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<BookDto> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDto> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(id, authorDto.id) && Objects.equals(name, authorDto.name) &&
                Objects.equals(surname, authorDto.surname) && Objects.equals(day, authorDto.day) &&
                Objects.equals(month, authorDto.month) && Objects.equals(year, authorDto.year) &&
                gender == authorDto.gender && Objects.equals(books, authorDto.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, day, month, year, gender, books);
    }
}
