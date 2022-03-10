package Goldra9.bookStore.domain;

import Goldra9.bookStore.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryItem
{

    @Id @GeneratedValue
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public CategoryItem(Item item, Category category) {
        this.item = item;
        this.category = category;
    }

    public static CategoryItem createCategoryItem(Item item, Category category)
    {
        CategoryItem categoryItem = new CategoryItem(item, category);
        return categoryItem;
    }

}
