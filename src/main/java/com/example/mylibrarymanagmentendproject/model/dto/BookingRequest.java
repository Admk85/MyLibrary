package com.example.mylibrarymanagmentendproject.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookingRequest {
    private String userCardId;
    private LocalDate bookingStartDate;
    private LocalDate bookingEndDate;
    private Long bookId;
}
