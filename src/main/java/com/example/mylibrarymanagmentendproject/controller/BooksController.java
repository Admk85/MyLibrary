package com.example.mylibrarymanagmentendproject.controller;


import com.example.mylibrarymanagmentendproject.model.dao.Books;
import com.example.mylibrarymanagmentendproject.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") //PM: niepotrzebne, jeśli nie mamy frontu napisanego w angularze, ta instrukcja mówi, że
//strona localhost:4200 może odpytywać ten endpoint;
@Slf4j
class BooksController { //klasa Controllera powinna być publiczna

    private final BookService bookService;

    //zgodnie z metodologią REST, sugerowane ścieżki https://sztukakodu.pl/15-zasad-przy-budowie-rest-api-za-ktore-deweloperzy-cie-pokochaja/
    //metoda http /sciezka --aktualna nazwa metody
    //GET /books --getBooks
    //POST /books --addBooks
    //GET /books/count --getCount
    //DELETE /books/{id} --delete
    //GET /books/access --getAccess przy okazji, do czego to ma sluzyc ? chyba cos w stylu dostepnosc, prawda ?
    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    public List<Books> getBooks(@RequestParam Map<String, String> params, HttpServletRequest request, HttpServletResponse response) { //PM: jeśli nie korzystamy z obiektów typu
        //request, response, to nie musimy ich podawać w parametrach, tak samo obiekt params miał tylko pokazać że można w ten sposób wykorzystać parametry, ale jak z nich
        //nic nie wyciagamy, to nie jest tu niezbedny
        System.out.println((params)); //mozna wyrzucic
        return bookService.getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addBooks(@RequestBody List<Books> books) {
        bookService.save((Books) books);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return bookService.getCount();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody List<Books> books) {
        bookService.deleteByISBN((Books) books);
    } //tutaj przyjmowana jest lista, ktora jest potem rzutowana na
    //pojedynczy obiekt, to się prawdopodobnie nie uda ;)

    @RequestMapping(value = "/access", method = RequestMethod.GET)
    public List<Books> getAccess(@RequestBody List<Books> books) {
        bookService.getAllByAccess(true);
        return books;
    }
}








