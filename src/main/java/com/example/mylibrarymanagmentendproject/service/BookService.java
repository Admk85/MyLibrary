package com.example.mylibrarymanagmentendproject.service;
import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import com.example.mylibrarymanagmentendproject.model.dto.BookRequest;
import com.example.mylibrarymanagmentendproject.model.dto.BookUpdate;
import com.example.mylibrarymanagmentendproject.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public int  getBookCopyCounts(Long bookId )
    {
          return  bookRepository.findById(bookId).orElseThrow().getCopies();
    }

    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }


    public List<Book> getByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }
    public List<Book> getByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }
    public List<Book> getByTittle(String tittle) {
        return bookRepository.findByTittle(tittle);

    }

    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }


    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book updateBook(BookUpdate bookUpdate, Long bookId) {
        Book book=bookRepository.findById(bookId).orElseThrow();
        book.setAvailable(bookUpdate.getAvailable());
        book.setIsbn(bookUpdate.getIsbn());
        book.setAuthor(bookUpdate.getAuthor());
        book.setTittle(bookUpdate.getTittle());
        return bookRepository.save(book);

    }
}







