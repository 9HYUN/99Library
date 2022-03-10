package Goldra9.bookStore.domain.item;

import Goldra9.bookStore.domain.Category;

import Goldra9.bookStore.domain.CategoryItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int rentalPrice;

    private int stockQuantity;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<CategoryItem> categoryItemList = new ArrayList<>();

    //== 비즈니스 로직 ==//
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new RuntimeException("대여 수량이 재고보다 많습니다.");
        }
        this.stockQuantity = restStock;
    }


    //== 연관 관계 메서드==//
    public void addCategoryItem(CategoryItem categoryItem)
    {
        categoryItemList.add(categoryItem);
        categoryItem.setItem(this);
    }

//    //== 생성 메서드==//
//    public static Item createItem(CategoryItem... categoryItemList)
//    {
//        Item item = new Item();
//                for(CategoryItem categoryItem : categoryItemList)
//        {
//            item.addCategoryItem(categoryItem);
//        }
//
//        return item;
//    }

    public Item(String name, int rentalPrice, int stockQuantity) {
        this.name = name;
        this.rentalPrice = rentalPrice;
        this.stockQuantity = stockQuantity;
    }
}



