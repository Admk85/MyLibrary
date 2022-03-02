package com.example.mylibrarymanagmentendproject.model.dao;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "copies", nullable = false)
    private int  copies;
    @Column(name = "isbn", unique = true, length = 13)
    private String isbn;
    @Column(name = "author")
    private String author;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "genre")
    private String genre;
    @Column(name= "availability ")
    private boolean availability ;



}
