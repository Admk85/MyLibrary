package com.example.mylibrarymanagmentendproject.model.dto;


import lombok.Getter;
import lombok.Setter;
import validation.PeselAndBirthdate;

import java.time.LocalDate;

@Getter
@Setter
@PeselAndBirthdate
public class UserRequest {
    private String pesel;
    private LocalDate birthday;
}

