package com.example.library.repository;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select distinct b from Book as b " +
            "join Book_Author as ba on b.id = ba.BookId " +
            "join Author as a on a.id = ba.AuthorId where a.name =:name")
    List<Book> findAuthorByName(@Param("name") String name);

    @Query("select distinct b from Book as b " +
            "join Book_Author as ba on b.id = ba.BookId " +
            "join Author as a on a.id = ba.AuthorId where a.surname =:surname")
    List<Book> findAuthorBySurname(@Param("surname") String surname);

    @Query("select distinct b from Book as b " +
            "join Book_Author as ba on b.id = ba.BookId " +
            "join Author as a on a.id = ba.AuthorId where a.name Like :symbol%")
    List<Book> findAuthorByNameIsStartingWith(@Param("symbol") String symbol);

    @Query("select distinct b from Book as b " +
            "join Book_Author as ba on b.id = ba.BookId " +
            "join Author as a on a.id = ba.AuthorId where a.surname Like :symbol%")
    List<Book> findAuthorBySurnameIsStartingWith(@Param("symbol") String symbol);

    @Query("select distinct b from Book as b " +
            "join Book_Author as ba on b.id = ba.BookId " +
            "join Author as a on a.id = ba.AuthorId where a.day =:day")
    List<Book> findAuthorByDay(@Param("day") Integer day);

    @Query("select distinct b from Book as b " +
            "join Book_Author as ba on b.id = ba.BookId " +
            "join Author as a on a.id = ba.AuthorId where a.month =:month")
    List<Book> findAuthorByMonth(@Param("month") Integer month);

    @Query("select distinct b from Book as b " +
            "join Book_Author as ba on b.id = ba.BookId " +
            "join Author as a on a.id = ba.AuthorId where a.year =:year")
    List<Book> findAuthorByYear(@Param("year") Integer year);

   @Query("select distinct b from Book as b " +
           "join Book_Author as ba on b.id = ba.BookId " +
           "join Author as a on a.id = ba.AuthorId where a.gender = :gender")
    List<Book> findAuthorByGender(@Param("gender") String gender);

    List<Author> findAuthorById(Long id);

    @Query("")
    void deleteById(Long id);

}
