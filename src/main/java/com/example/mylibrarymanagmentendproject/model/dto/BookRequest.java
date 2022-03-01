package com.example.mylibrarymanagmentendproject.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequest {
    private String ISBN;
    private String Tittle;
    private String Author;
    private LocalDateTime bookingStarDate;
    private LocalDateTime bookingEndDate;
    private LocalDateTime returnsDate;
}
