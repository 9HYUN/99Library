package Goldra9.bookStore.domain;

import Goldra9.bookStore.domain.item.Item;
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
    @JoinColumn(name = "order_id")
    private Item item;

    private int rentalPrice;

    private int count;

    public static RentalItem createRentalItem(Item item, int rentalPrice, int count)
    {
        RentalItem rentalItem = new RentalItem();
        rentalItem.setItem(item);
        rentalItem.setRentalPrice(rentalPrice);
        rentalItem.setCount(count);
        item.removeStock(count);
        return rentalItem;
    }

    public void cancelOrReturn()
    {
        getItem().addStock(count);
    }

    public int getTotalPrice()
    {
        int totalPrice = getRentalPrice() * getCount();
        return totalPrice;
    }

}
