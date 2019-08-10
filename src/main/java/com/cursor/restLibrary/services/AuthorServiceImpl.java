package com.cursor.restLibrary.services;

import com.cursor.restLibrary.beans.Author;
import com.cursor.restLibrary.beans.Book;

import com.cursor.restLibrary.repositories.IAuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService {
    private final IAuthorRepo iAuthorRepository;

    @Override
    public Author addAuthor(Author a) {
        a.setBooksWritten(new ArrayList<>());
        return iAuthorRepository.addAuthor(a);
    }

    @Override
    public void deleteAuthor(Integer deletedAuthorId) {
        iAuthorRepository.deleteAuthor(deletedAuthorId);
    }

    @Override
    public Author getById(Integer authorId) {
        return iAuthorRepository.getById(authorId);
    }

    public List<Book> sortByAuthor(Integer authorId) {
        return iAuthorRepository.sortByAuthor(authorId);
    }


    @Override
    public Author updateAuthor(Integer authorId, Author a) {
        Author author = new Author();
        author.setId(a.getId());
        author.setFirstName(a.getFirstName());
        author.setLastName(a.getLastName());
        return iAuthorRepository.updateAuthor(authorId, author);
    }

    @Override
    public Boolean addBookToAuthor(Integer authorId, Integer bookId) {
        return iAuthorRepository.addBook(authorId, bookId);
    }
}





