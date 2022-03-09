package Goldra9.bookStore.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Rental {

    @Id @GeneratedValue
    @Column(name = "rental_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime rentalDate;

    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    @OneToMany(mappedBy = "rental",cascade = CascadeType.ALL)
    private List<RentalItem> rentalItemList = new ArrayList<>();


    //== 연관관계 메서드==//
    public void setMember(Member member)
    {
        this.member = member;
        member.getRentalList().add(this);
    }

    public void addRentalItem(RentalItem rentalItem)
    {
        rentalItemList.add(rentalItem);
        rentalItem.setRental(this);
    }



    //== 생성 메서드 ==//
    public static Rental createRental(Member member, RentalItem... rentalItemList)
    {
        Rental rental = new Rental();
        rental.setMember(member);
        rental.setRentalStatus(RentalStatus.RENTAL);
        rental.setRentalDate(LocalDateTime.now());

        for(RentalItem rentalItem : rentalItemList)
        {
            rental.addRentalItem(rentalItem);
        }

        return rental;
    }

    //== 대여 취소 및 반납 ==//
    public void cancelOrReturn()
    {
        this.setRentalStatus(RentalStatus.HAVE);
        for(RentalItem rentalItem : rentalItemList)
        {
            rentalItem.cancelOrReturn();
        }
    }
    
    
}

