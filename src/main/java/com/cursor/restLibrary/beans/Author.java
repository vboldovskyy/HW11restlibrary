package com.cursor.restLibrary.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Author  {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Book> booksWritten = new ArrayList<>();

}
