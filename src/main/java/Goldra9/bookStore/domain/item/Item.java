package Goldra9.bookStore.domain.item;

import Goldra9.bookStore.domain.Category;

import Goldra9.bookStore.domain.CategoryItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
public abstract class Item
{
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<CategoryItem> categoryList = new ArrayList<>();

    //==비즈니스 로직==//
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
        this.stockQuantity = restStock;
    }

    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
