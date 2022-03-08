package Goldra9.bookStore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Rental {

    @Id @GeneratedValue
    @Column(name = "rental_id")
    private Long id;

    private Member member;

    private Date rentalDate;

    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    private List<RentalItem> rentalItemList = new ArrayList<>();
}
