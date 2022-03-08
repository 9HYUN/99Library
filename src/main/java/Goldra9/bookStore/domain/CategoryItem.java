package Goldra9.bookStore.domain;

import Goldra9.bookStore.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryItem
{

    @Id @GeneratedValue
    @Column(name = "category_item_id")
    private Long id;

    private Item item;

    private Category category;

}
