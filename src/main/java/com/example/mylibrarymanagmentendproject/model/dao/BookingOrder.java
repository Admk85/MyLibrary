package com.example.mylibrarymanagmentendproject.model.dao;
import lombok.*;
import javax.persistence.*;
import java.sql.Date;


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
    @Column(name = "bookingId")
    private Long bookingId;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    @Column(name = "booking_start_date")
    private Date bookingStartDate;
    @Column(name = "bookingEndDate")
    private Date bookingEndDate;


}
