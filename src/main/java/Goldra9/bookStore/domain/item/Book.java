package Goldra9.bookStore.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
@AllArgsConstructor
public class Book extends Item
{
    private String author;
    private String publisher;
    private int isbn;

    public Book(String name, int price, int stockQuantity, String author, String publisher, int isbn) {
        super(name, price, stockQuantity);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
