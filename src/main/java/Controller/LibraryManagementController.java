package Controller;

import Repository.BookRepository;
import Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LibraryManagementController {


    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final OrderRepository orderRepository;


    }

