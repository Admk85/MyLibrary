package com.example.mylibrarymanagmentendproject.model.dao;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="library_orders")
public class BookingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="username",unique = true)
    private String userName;
    @Column( name = "isbn", unique = true, length = 13)
    private String isbn;
    @Column(name = "author")
    private String author;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "booking_start_date")
    private Date bookingStarDate;
    @Column(name = "bookingEndDate")
    private Date bookingEndDate;


}
