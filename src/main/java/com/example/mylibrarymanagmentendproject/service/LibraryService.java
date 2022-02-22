package com.example.mylibrarymanagmentendproject.service;

import com.example.mylibrarymanagmentendproject.model.dao.Books;
import com.example.mylibrarymanagmentendproject.model.dao.Library;
import com.example.mylibrarymanagmentendproject.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryService {


    private final LibraryRepository libraryRepository;

    public List<Library> getAllLibrary() {
        return libraryRepository.findAll();
    }

    public Optional<Library> getByLibraryId(Long libraryId) {
        return libraryRepository.findById(libraryId);
    }

    public List<Library> getByName(String name) {
        List<Library> librarys = new ArrayList<>();
        for (Library library : libraryRepository.findAll()) {
            if (library.getName().toLowerCase().contains(name.toLowerCase())) {
                librarys.add(library);
            }
        }
        return librarys;
    }
}
