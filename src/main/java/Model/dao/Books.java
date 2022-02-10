package Model.dao;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "copy_id", nullable = false)
    private Long copyId;
    @Column(unique = true, length = 13)
    private Long ISBN;
    @Column(name = "cover")
    private String cover;
    @Column(name = "author")
    private String author;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "genre")
    private String genre;
    @Column(name= "accessibile")
    private boolean accessibility;

}
