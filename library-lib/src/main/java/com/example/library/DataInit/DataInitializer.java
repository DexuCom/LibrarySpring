package com.example.library.DataInit;

import com.example.library.Constructs.Library;
import com.example.library.Service.LibraryService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {

    @Autowired
    private LibraryService libraryService;
    @Autowired

    @PostConstruct
    public void init() {

        Library library1 = new Library();
        library1.setId(UUID.fromString("2f9fc611-24be-48eb-9884-a1336aa6cee9"));
        library1.setName("Empik");
        Library library2 = new Library();
        library2.setId(UUID.fromString("3c190f60-2170-4440-8675-fb89e26c35d8"));
        library2.setName("Esyfloresy");
        Library library3 = new Library();
        library3.setId(UUID.fromString("3c190f60-2170-4440-8675-fb89e26c35d9"));
        library3.setName("Ksiegarnia");

        libraryService.saveLibrary(library1);
        libraryService.saveLibrary(library2);
        libraryService.saveLibrary(library3);
    }
}
