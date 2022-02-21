package com.example.mylibrarymanagmentendproject.model.dao;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="libraryUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Long userId;
    @Column(name="user_card_ID")
    private String userCardId;
    @Column(name="username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(unique = true, length = 25)
    private String firstname;
    @Column(unique = true, length = 25)
    private String surname;
    @Column(name = "town")
    private String town;
    @Column(name="postcode")
    private int  postcode;
    @Column(name = "address")
    private String address;
    @Column(name="telephone")
    private Long telephone;
    @Column(name="email")
    private String email;
    @Column(name="birthday")
    private Date birthday;
    @Column( name="register_date")
    private LocalDateTime registerDate;
    @Column( name="modyfication_date")
    private LocalDateTime modifyDate;

}
