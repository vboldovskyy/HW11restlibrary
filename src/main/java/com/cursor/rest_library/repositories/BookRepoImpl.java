package com.cursor.rest_library.repositories;


import com.cursor.rest_library.beans.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;


@Repository
@RequiredArgsConstructor
public class BookRepoImpl implements IBookRepo {

    private final Map<Integer, Book> booksMap = new HashMap<>();

    @PostConstruct
    private void addCoupleOfBooks() {
        Book first = new Book();
        first.setId(1);
        first.setDescription("Very dull book");
        first.setTitle("Holy Bible");
        first.setRating(3.2);
        booksMap.put(first.getId(), first);

        Book second = new Book();
        second.setId(1);
        second.setDescription("Very interesting book");
        second.setTitle("Head First Java");
        second.setRating(4.8);
        booksMap.put(second.getId(), second);
    }

    @Override
    public Book addBook(Book book) {
        if (book.getId() == null || booksMap.containsKey(book.getId())) {
            int newId = Math.abs(new Random().nextInt(Integer.MAX_VALUE));
            book.setId(newId);
            booksMap.put(newId, book);
            return book;
        } else {
            booksMap.put(book.getId(), book);
            return book;
        }
    }

    @Override
    public Book updateBook(Integer bookId, Book book) {
        if (!book.getId().equals( bookId))
            book.setId(bookId);
        booksMap.put(bookId, book);
        return book;
    }

    @Override
    public Book getBook(Integer bookId) {
        return booksMap.get(bookId);
    }

    @Override
    public List<Book> sortByGenre(String genre) {
        List<Book> result = new ArrayList<>(booksMap.values());
        result.sort((Book a, Book b) -> (a.getGenre() != null && a.getGenre().equals(genre)) ? -1 : 1);
        return result;
    }

    @Override
    public List<Book> sortByAuthor(Integer authorId) {
        List<Book> result = new ArrayList<>(booksMap.values());
        result.sort((Book a, Book b) -> (a.getAuthor() != null && a.getAuthor().getId().equals(authorId)) ? -1 : 1);
        return result;
    }


    @Override
    public void deleteBook(Integer deletedBookId) {
        booksMap.remove(deletedBookId);
    }
}

