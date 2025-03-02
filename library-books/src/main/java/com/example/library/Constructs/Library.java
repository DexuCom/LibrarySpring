package com.example.library.Constructs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "libraries")
public class Library {

    @Id
    private UUID id;

    @Column
    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books;

    public Library(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
