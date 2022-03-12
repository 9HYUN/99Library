package Goldra9.library.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm
{
    //== 도서 Form ==//
    private Long id;
    private String name;
    private int rentalPrice;
    private int stockQuantity;
    private String author;
    private String publisher;
    private int isbn;
}
