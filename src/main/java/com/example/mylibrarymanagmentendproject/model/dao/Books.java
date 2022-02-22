package com.example.mylibrarymanagmentendproject.model.dao;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books") //tabelka nazywa sie books, i to jest jak najbardziej ok, ale pojedynczy wpis moze sie nazywac Book a nie Books ;)
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "copies", nullable = false)
    private int copies;
    @Column(unique = true, length = 13)
    private Long ISBN;
    @Column(name = "author")
    private String author;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "genre")
    private String genre;
    @Column(name= "access") //moze availability (dostepnosc) zamiast access (bardziej dostep - uprawnienie)
    private boolean access;
    @Column(name= "returned") //jak dla mnie returned będzie zawsze == !access, w takim razie jednej mozna sie pozbyc ?
    private boolean returned;


}
