package com.example.mylibrarymanagmentendproject.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookResponse {
    private String ISBN;
    private String Tittle;
    private String Author;
    private boolean availability;
}
