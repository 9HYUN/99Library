package Goldra9.library.domain;

import Goldra9.library.domain.item.Item;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Category
{
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    List<Item> itemList = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
}
