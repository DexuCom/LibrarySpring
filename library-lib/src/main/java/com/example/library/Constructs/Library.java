package com.example.library.Constructs;

import jakarta.persistence.*;
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

    @Column(name = "name")
    private String name;

}
