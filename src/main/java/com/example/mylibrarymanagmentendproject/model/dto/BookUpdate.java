package com.example.mylibrarymanagmentendproject.model.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookUpdate {
    private Long bookId;
    private String isbn;
    private String tittle;
    private String author;
    private String available;

}
