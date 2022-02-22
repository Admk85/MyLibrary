package com.example.mylibrarymanagmentendproject.model.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookResponse {

    private Long id;
    private Long userId;
    private String title;
    private boolean completed;
}
