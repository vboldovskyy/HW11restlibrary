package com.cursor.restLibrary.beans;

import lombok.Data;


@Data
public class Book {

    private Integer id;
    private String title;
    private String genre = "";
    private String description;
    private Double rating;
    private Author author;

}
