package com.example.mylibrarymanagmentendproject.service;
import com.example.mylibrarymanagmentendproject.model.dao.Books;
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
    public Books save(Books books) {
        bookRepository.save(books);
        return books;
    }
    public Long getCount() {
        return bookRepository.count();
    }
    public int  getBookCopyCounts(Long bookId ) {
          return  bookRepository.findById(bookId).orElseThrow().getCopies();
    }
    public List<Books> getAll() {
        return bookRepository.findAll();
    }
    public void deleteByISBN(Books ISBN) {
        bookRepository.delete(ISBN);
    }
    public List<Books> getAvailability(boolean availability) {
        return bookRepository.findByAvailability(availability);
    }
    public List<Books> getBooksByAuthor(String author) {
        List<Books> book = new ArrayList<>();
        for (Books books : bookRepository.findAll()) {
            if (books.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                book.add(books);
            }
        }
        return book;
    }
    public List<Books> getByGenre(String genre) {
        List<Books> book = new ArrayList<>();
        for (Books books : bookRepository.findAll()) {
            if (books.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                book.add(books);
            }
        }
        return book;
    }

    public List<Books> getByTittle(String tittle) {
        List<Books> book = new ArrayList<>();
        for (Books books : bookRepository.findAll()) {
            if (books.getTittle().toLowerCase().contains(tittle.toLowerCase())) {
                book.add(books);
            }
        }
        return book;
    }

    public Optional<Books> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }
}




