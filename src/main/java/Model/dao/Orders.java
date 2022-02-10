package Model.dao;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="libraryOrders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long bookingId;
    @ManyToOne
    private Books books;
    @ManyToOne
    private Library libraryId;
    @ManyToOne
    private User user;
    @Column(name = "booking_start_date")
    @NotNull
    private Date bookingStarDate;
    @Column(name = "bookingEndDate")
    @NotNull
    private Date bookingEndDate;
    @Column(name= "returned")
    private Integer  returned;




}
