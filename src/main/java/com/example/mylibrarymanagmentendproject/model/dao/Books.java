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
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "copies", nullable = false)
    private int  copies;
    @Column(unique = true, length = 13)
    private Long ISBN;
    @Column(name = "author")
    private String author;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "genre")
    private String genre;
    @Column(name= "access")
    private boolean access;
    @Column(name= "returned")
    private boolean returned;


}
