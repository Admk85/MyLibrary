package com.example.mylibrarymanagmentendproject.service;

import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Long getCount() {
        return bookRepository.count();
    }

    public int getBookCopyCounts(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow().getCopies();
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void deleteByISBN(String ISBN) {
        bookRepository.deleteByIsbn(ISBN);
    }

    public List<Book> getAvailability(boolean availability) {
        return bookRepository.findByAvailability(availability);
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> book = new ArrayList<>();
        for (Book books : bookRepository.findAll()) {
            if (books.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                book.add(books);
            }
        }
        return book;
    }

    public List<Book> getByGenre(String genre) {
        List<Book> book = new ArrayList<>();
        for (Book books : bookRepository.findAll()) {
            if (books.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                book.add(books);
            }
        }
        return book;
    }

    public List<Book> getByTittle(String tittle) {
        List<Book> book = new ArrayList<>();
        for (Book books : bookRepository.findAll()) {
            if (books.getTittle().toLowerCase().contains(tittle.toLowerCase())) {
                book.add(books);
            }
        }
        return book;
    }

    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }
}




