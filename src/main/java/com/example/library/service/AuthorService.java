package com.example.library.service;

import com.example.library.entity.*;
import com.example.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public void saveAuthor(AuthorDto authorDto) throws ValidationException{
        validateAuthor(authorDto);
        Author author = authorRepository.saveAndFlush(convertFromAuthorDto(authorDto));
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public void editAuthor(AuthorDto authorDto) throws ValidationException{
        validateAuthor(authorDto);
        Author author = authorRepository.saveAndFlush(convertFromAuthorDto(authorDto));
    }

    private void validateAuthor(AuthorDto authorDto) throws ValidationException {
        if (authorDto== null) {
            throw new ValidationException("Object author is null.");
        }
        if (authorDto.getName() == null || authorDto.getSurname() == null || authorDto.getDay() == null ||
         authorDto.getMonth() == null || authorDto.getYear() == null || authorDto.getGender() == null) {
            throw new ValidationException("One of the author values is empty");
        }
    }

    public Author convertFromAuthorDto(AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setDay(authorDto.getDay());
        author.setMonth(authorDto.getMonth());
        author.setYear(authorDto.getYear());
        author.setGender(authorDto.getGender());
        return author;
    }

    public AuthorDto convertFromAuthorEntity(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());
        authorDto.setDay(author.getDay());
        authorDto.setMonth(author.getMonth());
        authorDto.setYear(author.getYear());
        authorDto.setGender(author.getGender());
        return authorDto;
    }

    public List<AuthorDto> findAll(){
        return authorRepository.findAll()
                .stream().map(this::convertFromAuthor)
                .collect(Collectors.toList());
    }

    public List<AuthorDto> findById(Long id) {
        return authorRepository.findAuthorById(id)
                .stream().map(this::convertFromAuthor)
                .collect(Collectors.toList());
    }

    private AuthorDto convertFromAuthor(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setDay(author.getDay());
        authorDto.setMonth(author.getMonth());
        authorDto.setYear(author.getYear());
        authorDto.setName(author.getName());
        authorDto.setSurname(author.getSurname());
        return authorDto;
    }
}
