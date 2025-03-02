package com.example.library.Service;

import com.example.library.Constructs.Library;
import com.example.library.Repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public Library getLibraryById(UUID libraryId) { return libraryRepository.findById(libraryId).orElse(null); }

    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public void deleteLibrary(UUID libraryId) {
        libraryRepository.deleteById(libraryId);
    }
}
