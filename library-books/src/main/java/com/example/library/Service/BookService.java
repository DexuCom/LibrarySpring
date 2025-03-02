package com.example.library.Service;

import com.example.library.Constructs.Book;
import com.example.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksByLibrary(UUID libraryId) {
        return bookRepository.findByLibraryId(libraryId);
    }

    public Book getBookById(UUID bookId) { return bookRepository.findById(bookId).orElse(null); }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void deleteBook(UUID bookId) {
        bookRepository.deleteById(bookId);
    }
}
