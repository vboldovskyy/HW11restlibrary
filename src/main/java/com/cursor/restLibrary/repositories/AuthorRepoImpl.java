package com.cursor.restLibrary.repositories;

import com.cursor.restLibrary.beans.Author;
import com.cursor.restLibrary.beans.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;


@Repository
@RequiredArgsConstructor
public class AuthorRepoImpl implements IAuthorRepo {


    private final IBookRepo bookRepo;
    private final Map<Integer, Author> authorsMap = new HashMap<>();

    @PostConstruct
    private void addCoupleOfAuthors() {
        Author first = new Author();
        first.setId(1);
        first.setBooksWritten(new ArrayList<>());
        first.setFirstName("Lesya");
        first.setLastName("Ukrainka");
        authorsMap.put(first.getId(), first);

        Author second = new Author();
        second.setId(2);
        second.setBooksWritten(new ArrayList<>());
        second.setFirstName("Ivan");
        second.setLastName("Franko");
        authorsMap.put(second.getId(), second);

    }

    @Override
    public Author addAuthor(Author author) {
        if (author.getId() == null || authorsMap.containsKey(author.getId())) {
            int newId = Math.abs(new Random().nextInt(Integer.MAX_VALUE));
            author.setId(newId);
            authorsMap.put(newId, author);
            return author;
        } else {
            authorsMap.put(author.getId(), author);
            return author;
        }
    }

    @Override
    public boolean addBook(Integer authorId, Integer bookId) {

        Author author = authorsMap.get(authorId);
        Book book = bookRepo.getBook(bookId);
        if (author == null || book == null){
            return false;}
        else {
            author.getBooksWritten().add(book);
            book.setAuthor(author);
            return true;
        }

    }

    @Override
    public void deleteAuthor(Integer authorId) {
        authorsMap.remove(authorId);
    }

    @Override
    public Author getById(Integer authorId) {
        return authorsMap.get(authorId);
    }

    @Override
    public List<Book> sortByAuthor(Integer authorId) {
        Author author = authorsMap.get(authorId);
        if (author == null) {return new ArrayList<>();}
        else {return author.getBooksWritten();}
    }

    @Override
    public Author updateAuthor(Integer authorId, Author author) {
        Author authorToUpdate = authorsMap.get(authorId);
        if (authorToUpdate == null) {
            author.setId(authorId);
            return addAuthor(author);
        } else {
            authorsMap.put(authorId, author);
            return author;
        }
    }
}
