package com.cursor.restLibrary.services;

import com.cursor.restLibrary.beans.Author;

public interface IAuthorService {
    Author addAuthor(Author a);

    void deleteAuthor(Integer deletedAuthorId);

    Author getById(Integer authorId);

    Author updateAuthor(Integer authorId, Author a);

    Boolean addBookToAuthor(Integer authorId, Integer bookId);
}
