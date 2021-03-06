package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByTitle(String title);

    List<Book> findBookByYear(Integer year);

    List<Book> findBookByPublishing(String publishing);

    List<Book> findBookById(Long id);

    void deleteById(Long id);

}
