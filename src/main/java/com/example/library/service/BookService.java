package com.example.library.service;

import com.example.library.entity.BookDto;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public BookDto saveBook(BookDto bookDto) throws ValidationException {
        validateBook(bookDto);
        Book saveBook = bookRepository.saveAndFlush(convertFromBookDto(bookDto));
        return convertFromBook(saveBook);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookDto editBook(BookDto bookDto) throws ValidationException {
        validateBook(bookDto);
        Book book = bookRepository.saveAndFlush(convertFromBookDto(bookDto));
        return convertFromBook(book);
    }

    public List<BookDto> findByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findById(Long id) {
        return bookRepository.findBookById(id)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findByYear(Integer year) {
        return bookRepository.findBookByYear(year)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findByPublishing(String publishing) {
        return bookRepository.findBookByPublishing(publishing)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findByAuthorName(String name) {
        return authorRepository.findAuthorByName(name)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());

    }

    public List<BookDto> findByAuthorSurname(String surname) {
        return authorRepository.findAuthorBySurname(surname)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());

    }

    public List<BookDto> findByAuthorNameSymbol(String firstSymbol) {
        return authorRepository.findAuthorByNameIsStartingWith(firstSymbol)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findByAuthorSurnameSymbol(String firstSymbol) {
        return authorRepository.findAuthorBySurnameIsStartingWith(firstSymbol)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findByAuthorDay(Integer day) {
        return authorRepository.findAuthorByDay(day)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findByAuthorMonth(Integer month) {
        return authorRepository.findAuthorByMonth(month)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findByAuthorYear(Integer year) {
        return authorRepository.findAuthorByYear(year)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findByAuthorGender(String gender) {
        if (!gender.equals("Male") && !gender.equals("Female") && !gender.equals("Undefined")) {
            gender = "Undefined";
        }
        return authorRepository.findAuthorByGender(gender)
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> findAll(){
        return bookRepository.findAll()
                .stream().map(this::convertFromBook)
                .collect(Collectors.toList());
    }

    private void validateBook(BookDto bookDto) throws ValidationException {
        if (bookDto == null) {
            throw new ValidationException("Object book is null.");
        }
        if (bookDto.getTitle() == null || bookDto.getYear() == null || bookDto.getPublishing() == null) {
            throw new ValidationException("One of the book values is empty");
        }
    }

    private Book convertFromBookDto(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setYear(bookDto.getYear());
        book.setPublishing(bookDto.getPublishing());
        return book;
    }

    private BookDto convertFromBook(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setYear(book.getYear());
        bookDto.setPublishing(book.getPublishing());
        return bookDto;
    }
}
