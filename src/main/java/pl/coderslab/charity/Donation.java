package pl.coderslab.charity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

//    @ManyToMany
//    @Column(name = "categories")
//    private List<Category> categories = new ArrayList<>();

//    @ManyToOne
//    @Column(name = "institution")
//    private Institution institution;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "pickup_date")
    private LocalDate pickUpDate;

    @Column(name = "pickup_time")
    private LocalTime pickUpTime;

    @Column(name = "pickup_comment")
    private String pickUpComment;

}
