package com.cursor.rest_library.services;

import com.cursor.rest_library.beans.Author;
import com.cursor.rest_library.beans.Book;

import java.util.List;

public interface IAuthorService {
    Author addAuthor(Author a);

    void deleteAuthor(Integer deletedAuthorId);

    Author getById(Integer authorId);

    Author updateAuthor(Integer authorId, Author a);

    Boolean addBookToAuthor(Integer authorId, Integer bookId);
}
