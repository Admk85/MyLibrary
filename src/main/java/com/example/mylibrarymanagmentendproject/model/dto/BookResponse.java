package com.example.mylibrarymanagmentendproject.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Builder
public class BookResponse {
    private String userName;
    private Long id;
    private String isbn;
    private String tittle;
    private String author;
    public boolean isAvailability;
    private Date bookingStarDate;
    private Date bookingEndDate;
}
