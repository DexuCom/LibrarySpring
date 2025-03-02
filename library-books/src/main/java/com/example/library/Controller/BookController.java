package com.example.library.Controller;

import lombok.extern.java.Log;
import com.example.library.Constructs.Book;
import com.example.library.Constructs.Library;
import com.example.library.DTO.Book.BookDTO;
import com.example.library.DTO.Book.BookDTOCreate;
import com.example.library.DTO.Book.BookDTOList;
import com.example.library.DTO.Book.BookDTOPost;
import com.example.library.Service.BookService;
import com.example.library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.stream.Collectors;

@RestController
@Log
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/api/books")
    public ResponseEntity<List<BookDTOList>> getAllBooks() {

        List<BookDTOList> books = bookService.getAllBooks().stream()
                .map(book -> {
                    BookDTOList dto = new BookDTOList();
                    dto.setId(book.getId());
                    dto.setTitle(book.getTitle());
                    return dto;
                })
                .collect(Collectors.toList());

        log.log(Level.INFO, "getAllBooks");

        return ResponseEntity.ok(books);
    }

    @GetMapping("/api/books/{bookId}")
    public ResponseEntity<BookDTO> getBook(@PathVariable UUID bookId) {

        Book book = bookService.getBookById(bookId);
        if (book == null) return ResponseEntity.notFound().build();

        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPages(book.getPages());
        dto.setLibrary(book.getLibrary().getName());

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/api/libraries/{libraryId}/books")
    public ResponseEntity<List<BookDTOList>> getBooksInLibrary(@PathVariable UUID libraryId) {

        Library library = libraryService.getLibraryById(libraryId);
        if (library == null) return ResponseEntity.notFound().build();

        List<BookDTOList> books = bookService.getBooksByLibrary(libraryId).stream()
                .map(book -> {
                    BookDTOList dto = new BookDTOList();
                    dto.setId(book.getId());
                    dto.setTitle(book.getTitle());
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(books);
    }

    @GetMapping("/api/libraries/{libraryId}/books/{bookId}")
    public ResponseEntity<BookDTO> getBookInLibrary(@PathVariable UUID libraryId, @PathVariable UUID bookId) {

        Library library = libraryService.getLibraryById(libraryId);
        Book book = bookService.getBookById(bookId);

        if (library == null) return ResponseEntity.notFound().build();
        if (book == null || !book.getLibrary().getId().equals(libraryId)) return ResponseEntity.notFound().build();

        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPages(book.getPages());
        dto.setLibrary(library.getName());

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/api/books")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTOPost dto) {

        Library library = libraryService.getLibraryById(UUID.fromString(dto.getLibrary()));
        if (library == null) return ResponseEntity.notFound().build();

        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPages(dto.getPages());
        book.setLibrary(library);

        bookService.saveBook(book);

        BookDTO readDTO = new BookDTO();
        readDTO.setId(book.getId());
        readDTO.setTitle(book.getTitle());
        readDTO.setAuthor(book.getAuthor());
        readDTO.setPages(book.getPages());
        readDTO.setLibrary(book.getLibrary().getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(readDTO);
    }


    @PutMapping("/api/books/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable UUID bookId, @RequestBody BookDTOCreate dto) {

        Book book = bookService.getBookById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPages(dto.getPages());

        bookService.saveBook(book);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID bookId) {

        Book book = bookService.getBookById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/libraries/{libraryId}/books")
    public ResponseEntity<BookDTO> createBookInLibrary(@PathVariable UUID libraryId, @RequestBody BookDTOCreate dto) {
        Library library = libraryService.getLibraryById(libraryId);
        if (library == null) return ResponseEntity.notFound().build();

        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPages(dto.getPages());
        book.setLibrary(library);

        book = bookService.saveBook(book);

        BookDTO readDto = new BookDTO();
        readDto.setId(book.getId());
        readDto.setTitle(book.getTitle());
        readDto.setAuthor(book.getAuthor());
        readDto.setPages(book.getPages());
        readDto.setLibrary(library.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(readDto);
    }

    @PutMapping("/api/libraries/{libraryId}/books/{bookId}")
    public ResponseEntity<Void> updateBookInLibrary(@PathVariable UUID libraryId, @PathVariable UUID bookId, @RequestBody BookDTOCreate dto) {

        Library library = libraryService.getLibraryById(libraryId);
        if (library == null) return ResponseEntity.notFound().build();

        Book book = bookService.getBookById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPages(dto.getPages());

        bookService.saveBook(book);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/libraries/{libraryId}/books/{bookId}")
    public ResponseEntity<Void> deleteBookInLibrary(@PathVariable UUID libraryId, @PathVariable UUID bookId) {
        var book = bookService.getBookById(bookId);
        if (book == null || !book.getLibrary().getId().equals(libraryId)) {
            return ResponseEntity.notFound().build();
        }

        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }
}
