package com.example.mylibrarymanagmentendproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {


        @Min(value = 0)
        private Long bookID;
        @NotEmpty
        @Length(max = 25)
        private String title;
        private boolean completed;
}
