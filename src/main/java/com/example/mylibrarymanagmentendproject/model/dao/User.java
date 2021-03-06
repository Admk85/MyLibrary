package com.example.mylibrarymanagmentendproject.model.dao;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

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
    @Column(name = "userId")
    private Long userId;
    @Column( name="user_card_Id")
    private String userCardId;
    @Column(name="username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column( length = 25)
    private String firstname;
    @Column( length = 25)
    private String surname;
    @Column(name = "town")
    private String town;
    @Column(name="postcode")
    private Long  postcode;
    @Column(name = "address")
    private String address;
    @Column(name="telephone")
    private Long telephone;
    @Column( name="email")
    private String email;
    @Column(name="birthday")
    private Date birthday;
    @Column( name="register_date")
    private LocalDateTime registerDate;
    @Column( name="modyfication_date")
    private LocalDateTime modifyDate;

}
