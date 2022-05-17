package com.example.mylibrarymanagmentendproject.model.dto;

import com.example.mylibrarymanagmentendproject.model.dao.Book;
import com.example.mylibrarymanagmentendproject.model.dao.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class BookResponse {
    private Long bookId;
    private String isbn;
    private String tittle;
    private String author;
    public String available;


}
