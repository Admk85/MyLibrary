package com.example.mylibrarymanagmentendproject.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class BookingRequest {
    private String UserCardId;
    private Date bookingStartDate;
    private Date bookingEndDate;
    private Long bookId;
    private String  returned;

}
