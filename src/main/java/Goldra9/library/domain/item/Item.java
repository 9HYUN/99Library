package Goldra9.library.domain.item;

import Goldra9.library.domain.Category;
import Goldra9.library.domain.RentalItem;
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
public abstract class Item
{
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String name;
    private int rentalPrice;
    private int stockQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    //== 수량 추가 로직 ==//
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    //== 수량 제거 로직 ==//
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new RuntimeException("대여 수량이 재고보다 많습니다.");
        }
        this.stockQuantity = restStock;
    }

    //== 연관관계 메서드==//
    public void setCategory(Category category) {
        this.category = category;
        category.getItemList().add(this);
    }

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<RentalItem> rentalItemList = new ArrayList<>();

    public Item(String name, int rentalPrice, int stockQuantity, Category category)
    {
        this.name = name;
        this.rentalPrice = rentalPrice;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }
}



