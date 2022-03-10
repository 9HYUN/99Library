package Goldra9.bookStore.domain.item;

import Goldra9.bookStore.domain.Category;
import lombok.AllArgsConstructor;
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
    private int isbn;

    public Book(String name, int rentalPrice, int stockQuantity, String author, String publisher, int isbn) {
        super(name ,rentalPrice, stockQuantity);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
