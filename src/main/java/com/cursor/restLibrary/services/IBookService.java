package com.cursor.restLibrary.services;

import com.cursor.restLibrary.beans.Book;

import java.util.List;

public interface IBookService {
    Book addBook(Book book);

    Book updateBook(Integer bookId, Book b);

    Book getBookById(Integer bookId);

    List<Book> sortByGenre(String genre);

    List<Book> sortByAuthor(Integer authorId);

    void deleteBook(Integer deletedBookId);
}
