package com.example.mylibrarymanagmentendproject.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookUpdateResponse {

        private Long bookId;
        private String isbn;
        private String tittle;
        private String author;
        public String available;


    }
