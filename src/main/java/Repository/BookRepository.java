package Repository;

import Model.dao.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Books, Long> {
    Optional <Books> findByISBN(Long ISBN);
    List <Books> getByAuthor(String author);
    List <Books>getByGenre(String genre);
    List <Books>getByTittle(String tittle);
    List <Books>getByTittleAndAuthor(String tittle, String author);
    List< Books> searchBooksByAuthorAndTittle(String author, String tittle);






}
