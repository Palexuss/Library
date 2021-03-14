package com.example.library.controller;

import com.example.library.entity.AuthorDto;
import com.example.library.service.AuthorService;
import com.example.library.service.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/new")
    public String saveAuthor(@RequestBody AuthorDto authorDto) throws ValidationException{
        authorService.saveAuthor(authorDto);
        return "redirect:/authors";
    }

    @PutMapping("/edit")
    public String editAuthor(@RequestBody AuthorDto authorDto) throws ValidationException{
        authorService.editAuthor(authorDto);
        return "redirect:/authors";
    }

    @GetMapping("/list")
    public List<AuthorDto> findAll(){
        return authorService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public List<AuthorDto> findById(@PathVariable("id") Long id){
        return authorService.findById(id);
    }

    @DeleteMapping("/delete-author/{id}")
    public void deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthor(id);
    }

}
