package com.example.library.controller;

import com.example.library.entity.BookDto;
import com.example.library.service.BookService;
import com.example.library.service.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/new")
    public BookDto saveBook(@RequestBody BookDto bookDto) throws ValidationException{
        return bookService.saveBook(bookDto);
    }

    @PutMapping("/edit")
    public BookDto editBook(@RequestBody BookDto bookDto) throws ValidationException{
        return bookService.editBook(bookDto);
    }

    @GetMapping("/find-by-title/{title}")
    public List<BookDto> findByTitle(@PathVariable("title") String title){
        return bookService.findByTitle(title);
    }

    @GetMapping("/find-by-id/{id}")
    public List<BookDto> findById(@PathVariable("id") Long id){
        return bookService.findById(id);
    }

    @GetMapping("/find-by-year/{year}")
    public List<BookDto> findByYear(@PathVariable("year") Integer year){
        return bookService.findByYear(year);
    }

    @GetMapping("/find-by-publishing/{publishing}")
    public List<BookDto> findByPublishing(@PathVariable("publishing") String publishing){
        return bookService.findByPublishing(publishing);
    }

    @GetMapping("/find-by-name/{name}")
    public List<BookDto> findByAthName(@PathVariable("name") String name){
        return bookService.findByAuthorName(name);
    }

    @GetMapping("/find-by-surname/{surname}")
    public List<BookDto> findByAthSurname(@PathVariable("surname") String surname){
        return bookService.findByAuthorSurname(surname);
    }

    @GetMapping("/find-by-first-name-symbol/{symbol}")
    public List<BookDto> findByAthNameSym(@PathVariable("symbol") String symbol){
        return bookService.findByAuthorNameSymbol(symbol);
    }

    @GetMapping("/find-by-first-surname-symbol/{symbol}")
    public List<BookDto> findByAthSurnameSym(@PathVariable("symbol") String symbol){
        return bookService.findByAuthorSurnameSymbol(symbol);
    }

    @GetMapping("/find-by-author-day/{day}")
    public List<BookDto> findByAthDay(@PathVariable("day") Integer day){
        return bookService.findByAuthorDay(day);
    }

    @GetMapping("/find-by-author-month/{month}")
    public List<BookDto> findByAthMonth(@PathVariable("month") Integer month){
        return bookService.findByAuthorMonth(month);
    }

    @GetMapping("/find-by-author-year/{year}")
    public List<BookDto> findByAthYear(@PathVariable("year") Integer year){
        return bookService.findByAuthorYear(year);
    }

    @GetMapping("/find-by-gender/{gender}")
    public List<BookDto> findByAthGender(@PathVariable("gender") String gender){
        return bookService.findByAuthorGender(gender);
    }

    @GetMapping("/list")
    public List<BookDto> findAll(){
        return bookService.findAll();
    }

    @RequestMapping(value = "/delete/{id}" , method = {RequestMethod.DELETE, RequestMethod.GET})
    public void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }
}
