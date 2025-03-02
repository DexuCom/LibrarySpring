package com.example.library.Repository;

import com.example.library.Constructs.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryRepository extends JpaRepository<Library, UUID> {
}
