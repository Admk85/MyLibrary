package com.example.mylibrarymanagmentendproject.service;
import com.example.mylibrarymanagmentendproject.model.dao.Books;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
import com.example.mylibrarymanagmentendproject.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void delete(Books books) {
        bookRepository.delete(books);
    }

    public Long getCount() {
        return bookRepository.count();

    }

    public int getBookCopyCounts(Long bookId ) {
          return  bookRepository.findById(bookId).orElseThrow().getCopies();

    }

    public List<Books> getAll() {
        return bookRepository.findAll();
    }

    public void deleteByISBN(Books ISBN) {
        bookRepository.delete(ISBN);
    }

    public boolean getAllByAccess(boolean access) {
        bookRepository.findAllByAccess(access);
        return access;
    }

    public Optional<Books> getById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Books> getAuthor(String author) {
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
}




