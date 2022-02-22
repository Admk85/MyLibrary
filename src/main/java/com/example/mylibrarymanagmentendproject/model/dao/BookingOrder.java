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
@Table(name="libraryOrders") //zgodnie z konwencją bazodanową, tabela powinna mieć nazwę LIBRARY_ORDERS (z "podłogą")
public class BookingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long bookingId;
    @ManyToOne
    private Books books;
    @ManyToOne
    private Library library;
    @ManyToOne
    private User user;
    @Column(name = "booking_start_date")
    @NotNull
    private LocalDateTime bookingStarDate; //nie wykluczam ze bedzie tu brakowac jakiegos convertera, ale sprawdzimy jak juz odpalimy
    @Column(name = "bookingEndDate")
    @NotNull
    private LocalDateTime bookingEndDate;
    @NotNull
    @Column(name = "returnDate")
    private LocalDateTime returnsDate;

}
