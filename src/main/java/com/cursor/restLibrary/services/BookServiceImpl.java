package com.cursor.restLibrary.services;

import com.cursor.restLibrary.beans.Book;
import com.cursor.restLibrary.repositories.IBookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {
    private final IBookRepo iBookRepository;

    @Override
    public Book addBook(Book book) {
        return iBookRepository.addBook(book);
    }

    @Override
    public Book updateBook(Integer bookId, Book b) {
        return iBookRepository.updateBook(bookId, b);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return iBookRepository.getBook(bookId);
    }

    @Override
    public List<Book> sortByGenre(String genre) {
        return iBookRepository.sortByGenre(genre);
    }

    @Override
    public List<Book> sortByAuthor(Integer authorId) {
        return iBookRepository.sortByAuthor(authorId);
    }

    @Override
    public void deleteBook(Integer deletedBookId) {
        iBookRepository.deleteBook(deletedBookId);
    }
}