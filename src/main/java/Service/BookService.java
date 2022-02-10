package Service;

import Model.dao.Books;
import Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    BookRepository bookRepository;


    public void addBooks(@RequestBody List<Books> books) {
        bookRepository.saveAll(books);

    }
    public Long getTotalCount() {
        return bookRepository.count();
    }


    public void delete(Books books) {
        bookRepository.delete(books);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }



    public void saveById(Long id) {

        bookRepository.save(bookRepository.findById(id).get());
    }

    public List<Books> findAll() {
        return (List<Books>) bookRepository.findAll();

    }

    public Books findByISBN(Long ISBN) {
        Books books = bookRepository.findByISBN(ISBN).get();
        return books;
    }

    public List<Books> getByAuthor(String author) {
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
    public List<Books> getByTittleAndAuthor(String tittle, String author) {
        List<Books> book = new ArrayList<>();
        for (Books books : bookRepository.findAll()) {
            if (books.getTittle().toLowerCase().contains(tittle.toLowerCase())&&
                    books.getAuthor().toLowerCase().contains(author.toLowerCase()))  {
                book.add(books);
            }
        }
        return book;
    }
public List<Books> searchBooksByAuthorAndTittle(String author, String tittle){
    List<Books>searchBooksByAuthorAndTittle=new ArrayList<Books>();
    if( author!= null&& tittle==null) {

    } else if (author== null&& tittle!=null){
          searchBooksByAuthorAndTittle = getByTittle(tittle);
       } else if (author!= null&& tittle!=null){
            searchBooksByAuthorAndTittle=getByTittleAndAuthor(author, tittle);}
        return searchBooksByAuthorAndTittle;

        }


    }





