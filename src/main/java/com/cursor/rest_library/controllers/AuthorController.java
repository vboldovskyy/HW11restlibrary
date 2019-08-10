package com.cursor.rest_library.controllers;

import com.cursor.rest_library.beans.Author;
import com.cursor.rest_library.services.IAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
    private final IAuthorService authorService;

    @PostMapping("/add")
    @ResponseBody
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Integer authorId) {
        authorService.deleteAuthor(authorId);
    }

    @GetMapping("/{authorId}")
    public Author getById(@PathVariable("authorId") Integer authorId) {
        return authorService.getById(authorId);
    }

    @PutMapping("/{authorId}")
    public Author updateAuthor(@PathVariable("authorId") Integer authorId, @RequestBody Author author) {
        return authorService.updateAuthor(authorId, author);
    }

    @PostMapping("/addBook/{authorId}/{bookId}")
    public Boolean addBookToAuthor(@PathVariable("authorId") Integer authorId, @PathVariable("bookId") Integer bookId) {
        return authorService.addBookToAuthor(authorId, bookId);
    }
}
