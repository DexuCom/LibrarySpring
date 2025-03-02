package com.example.library.DTO.Book;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookDTO {

    private UUID id;
    private String title;
    private String author;
    private int pages;
    private String library;
}
