package com.cursor.rest_library.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Author implements Cloneable {
    private Integer id;
    private String firstName;
    private String LastName;
    private List<Book> booksWritten = new ArrayList<>();

}
