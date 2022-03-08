package Goldra9.bookStore.domain.item;

import Goldra9.bookStore.domain.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
public abstract class Item
{
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    public Item(Long id, String name, int price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    private List<Category> categoryList = new ArrayList<>();

    public void addStock(int quantity)
    {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity)
    {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0)
        {
            throw new RuntimeException("수량이 판매된 것보다 적습니다.");
        }
    }
}
