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
@Table(name="library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_Id", nullable = false)
    private Long libraryId;
    @Column(name="name")
    private String  name;
    @Column(name = "town")
    private String town;
    @Column(name = "address")
    private String address;
    @Column(name = "post_code")
    private String postcode;
    @Column(name = "telephone")
    private String telephone;
    @Column(name= "opening_hours")
    private Date date ;
}
