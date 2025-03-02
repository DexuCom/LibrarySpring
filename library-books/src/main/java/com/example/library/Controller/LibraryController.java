package com.example.library.Controller;

import com.example.library.Constructs.Library;
import com.example.library.DTO.Library.LibraryDTO;
import com.example.library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public ResponseEntity<Void> createLibrary(@RequestBody LibraryDTO dto) {

        Library library = new Library(dto.getId(), dto.getName());
        libraryService.saveLibrary(library);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable UUID libraryId) {

        Library library = libraryService.getLibraryById(libraryId);
        if (library == null) { return ResponseEntity.notFound().build(); }

        libraryService.deleteLibrary(libraryId);
        return ResponseEntity.noContent().build();
    }
}
