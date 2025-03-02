package com.example.library.Controller;

import com.example.library.Constructs.Library;
import com.example.library.DTO.Library.LibraryDTO;
import com.example.library.DTO.Library.LibraryDTOCreate;
import com.example.library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libraries")
public class  LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public ResponseEntity<List<LibraryDTO>> getAllLibraries() {

        List<LibraryDTO> libraries = libraryService.getAllLibraries().stream()
                .map(library -> {
                    LibraryDTO dto = new LibraryDTO();
                    dto.setId(library.getId());
                    dto.setName(library.getName());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(libraries);
    }

    @GetMapping("/{libraryId}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable UUID libraryId) {

        Library library = libraryService.getLibraryById(libraryId);
        if (library == null) { return ResponseEntity.notFound().build(); }

        LibraryDTO dto = new LibraryDTO();

        dto.setId(library.getId());
        dto.setName(library.getName());

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody LibraryDTOCreate dto) {
        Library library = new Library();
        library.setId(UUID.randomUUID());
        library.setName(dto.getName());

        libraryService.saveLibrary(library);

        LibraryDTO readDTO = new LibraryDTO();
        readDTO.setId(library.getId());
        readDTO.setName(library.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(readDTO);
    }

    @PutMapping("/{libraryId}")
    public ResponseEntity<Void> updateLibrary(@PathVariable UUID libraryId, @RequestBody LibraryDTOCreate dto) {
        Library library = libraryService.getLibraryById(libraryId);
        if (library == null) {
            return ResponseEntity.notFound().build();
        }

        library.setName(dto.getName());
        libraryService.saveLibrary(library);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable UUID libraryId) {

        Library library = libraryService.getLibraryById(libraryId);
        if (library == null) { return ResponseEntity.notFound().build(); }

        libraryService.deleteLibrary(libraryId);
        return ResponseEntity.noContent().build();
    }
}
