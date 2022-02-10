package Model.dao;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;

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
    @Column(name = "UserId", nullable = false)
    private Long UserId;
    @Column(name="user_card_ID")
    private Long UserCardID;
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



}
