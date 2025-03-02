package com.example.library.DataInit;

import com.example.library.Constructs.Book;
import com.example.library.Constructs.Library;
import com.example.library.Service.BookService;
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
    private BookService bookService;

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

        Book book1 = new Book();
        book1.setId(UUID.fromString("3c190f60-2170-4440-8675-fb89e16c35d8"));
        book1.setTitle("LOTR");
        book1.setAuthor("Tolkien");
        book1.setPages(1000);
        book1.setLibrary(library1);

        Book book2 = new Book();
        book2.setId(UUID.fromString("3c190f60-2170-4440-8675-fb89e26c3511"));
        book2.setTitle("Harry Potter");
        book2.setAuthor("Rowling");
        book2.setPages(200);
        book2.setLibrary(library1);

        Book book3 = new Book();
        book3.setId(UUID.fromString("3c190f60-2170-4440-8675-fb89e26c3510"));
        book3.setTitle("Harry Potterki");
        book3.setAuthor("Rowlinguś");
        book3.setPages(300);
        book3.setLibrary(library2);

        bookService.saveBook(book1);
        bookService.saveBook(book2);
        bookService.saveBook(book3);
    }
}
