package com.example.library.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable
public class Book_Author implements Serializable {

    @Id
    private Long BookId;
    @Id
    private Long AuthorId;

    public Long getBookId() {
        return BookId;
    }

    public void setBookId(Long bookId) {
        this.BookId = bookId;
    }

    public Long getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Long authorId) {
        this.AuthorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book_Author that = (Book_Author) o;
        return Objects.equals(BookId, that.BookId) && Objects.equals(AuthorId, that.AuthorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BookId, AuthorId);
    }
}
