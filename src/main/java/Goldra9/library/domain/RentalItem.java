package Goldra9.library.domain;

import Goldra9.library.domain.item.Item;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class RentalItem
{
    @Id @GeneratedValue
    @Column(name = "rental_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    private int rentalPrice;
    private int count;

    //==생성 메소드 ==//
    public static RentalItem createRentalItem(Item item, int Price, int count)
    {
        RentalItem rentalItem = new RentalItem();
        rentalItem.setItem(item);
        rentalItem.setRentalPrice(Price);
        rentalItem.setCount(count);
        item.removeStock(count);
        return rentalItem;
    }

    //==대여 취소 로직==//
    public void cancel()
    {
        getItem().addStock(count);
    }


}
