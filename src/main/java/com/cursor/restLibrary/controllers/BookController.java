package com.cursor.restLibrary.controllers;

import com.cursor.restLibrary.beans.Book;
import com.cursor.restLibrary.services.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    private final IBookService bookService;

    @PostMapping("/add")
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/update/{bookId}")
    public Book updateBook(@PathVariable("bookId") Integer bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/sortByGenre/{genre}")
    public List<Book> sortByGenre(@PathVariable("genre") String genre) {
        return bookService.sortByGenre(genre);
    }

    @GetMapping("/sortByAuthor/{authorId}")
    public List<Book> sortByAuthor(@PathVariable("authorId") Integer authorId) {
        return bookService.sortByAuthor(authorId);
    }

    @DeleteMapping("/{deletedBookId}")
    public void deleteBook(@PathVariable("deletedBookId") Integer deletedBookId) {
        bookService.deleteBook(deletedBookId);
    }
}
