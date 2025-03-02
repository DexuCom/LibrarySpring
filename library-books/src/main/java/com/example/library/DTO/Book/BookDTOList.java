package com.example.library.DTO.Book;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookDTOList {

    private UUID id;
    private String title;
}
