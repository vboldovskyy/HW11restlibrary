package com.cursor.restLibrary.repositories;

import com.cursor.restLibrary.beans.Author;
import com.cursor.restLibrary.beans.Book;

import java.util.List;

public interface IAuthorRepo {

    Author addAuthor(Author author);

    boolean addBook(Integer authorId, Integer bookId);

    void deleteAuthor(Integer deletedAuthorId);

    Author getById(Integer authorId);

    List<Book> sortByAuthor(Integer authorId);

    Author updateAuthor(Integer authorId, Author author);
}

