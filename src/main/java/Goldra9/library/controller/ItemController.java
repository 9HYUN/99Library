package Goldra9.library.controller;

import Goldra9.library.controller.form.BookForm;
import Goldra9.library.domain.item.Book;
import Goldra9.library.domain.item.Item;
import Goldra9.library.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    //== 도서 Form 등록 ==//
    @GetMapping("/items/new")
    private String createForm(Model model) {
        model.addAttribute("BookForm", new BookForm());
        return "items/createItemForm";
    }

    //== 도서 등록 ==//
    @PostMapping("/items/new")
    private String create(@Valid BookForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "items/createItemForm";
        }

        Book book = new Book(form.getName(), form.getRentalPrice(), form.getStockQuantity(),
                form.getAuthor(), form.getPublisher(), form.getIsbn());

        itemService.saveItem(book);

        return "redirect:/";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findAllItem();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model)
    {
        Book book = (Book) itemService.findOne(itemId);

        BookForm form = new BookForm();
        form.setId(book.getId());
        form.setAuthor(book.getAuthor());
        form.setPublisher(book.getPublisher());
        form.setIsbn(book.getIsbn());
        form.setName(book.getName());
        form.setRentalPrice(book.getRentalPrice());
        form.setStockQuantity(book.getStockQuantity());

        model.addAttribute("form", form);
        return "items/updateItemForm";
    }

    @PostMapping("items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") BookForm form)
    {
        Book book = new Book(form.getName(), form.getRentalPrice(), form.getStockQuantity(),
                             form.getAuthor(), form.getPublisher(), form.getIsbn());
        book.setId(form.getId());
        itemService.saveItem(book);
        return "redirect:/items";
    }

}
