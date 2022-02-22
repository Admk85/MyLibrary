package com.example.mylibrarymanagmentendproject.model.dto;


import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserRequest {
    private String pesel;
    private LocalDate birthday;
}

