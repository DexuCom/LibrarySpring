package com.example.library.Service;

import com.example.library.Constructs.Library;
import com.example.library.DTO.Library.LibraryDTO;
import com.example.library.Repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private static final String ELEMENTS_URL = "/api/libraries";

    public Library getLibraryById(UUID libraryId) { return libraryRepository.findById(libraryId).orElse(null); }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Library saveLibrary(Library library) {

        LibraryDTO dto = new LibraryDTO(library.getId(), library.getName());

        String uri = loadBalancerClient.choose("library-books").getUri().toString();

        restTemplate.postForEntity(uri+ELEMENTS_URL, dto, Void.class);

        return libraryRepository.save(library);
    }

    public void deleteLibrary(UUID libraryId) {
        libraryRepository.deleteById(libraryId);

        String uri = loadBalancerClient.choose("library-books").getUri().toString();

        restTemplate.delete(uri + ELEMENTS_URL + "/" + libraryId);
    }
}
