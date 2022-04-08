package Goldra9.library.domain.item;

import Goldra9.library.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Book extends Item
{
    private String author;
    private String publisher;
    private Long isbn;

    public Book(String name, int rentalPrice, int stockQuantity, Category category, String author, String publisher, Long isbn) {
        super(name ,rentalPrice, stockQuantity, category);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
