package com.cursor.restLibrary.repositories;

import com.cursor.restLibrary.beans.Book;

import java.util.List;

public interface IBookRepo {

    Book addBook(Book book);

    Book updateBook(Integer bookId, Book book);

    List<Book> sortByGenre(String genre);

    List<Book> sortByAuthor(Integer authorId);

    void deleteBook(Integer bookId);

    Book getBook(Integer bookId);
}
