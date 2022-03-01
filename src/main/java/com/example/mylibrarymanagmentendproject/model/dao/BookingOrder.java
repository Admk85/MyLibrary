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
    @ManyToOne
    private Books books;
    @ManyToOne
    private Library library;
    @ManyToOne
    private User user;
    @Column(name = "booking_start_date")
    @NotNull
    private LocalDateTime bookingStarDate;
    @Column(name = "bookingEndDate")
    @NotNull
    private LocalDateTime bookingEndDate;
    @NotNull
    @Column(name = "returnDate")
    private LocalDateTime returnsDate;

}
