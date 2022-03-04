package com.example.mylibrarymanagmentendproject.model.dto;

import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import lombok.*;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequest {
    private String userName;
    private Long bookId;
    private String isbn;
    private String tittle;
    private String author;



}
