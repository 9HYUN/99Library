package Goldra9.library.service;

import Goldra9.library.controller.form.BookForm;
import Goldra9.library.domain.item.Book;
import Goldra9.library.domain.item.Item;
import Goldra9.library.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService 
{
    private final ItemRepository itemRepository;
    
    @Transactional
    public void saveItem(Item item)
    {
        itemRepository.save(item);
    }
    
    @Transactional
    public void updateItem(Long id, BookForm book)
    {
        Book findItem = (Book) itemRepository.findOne(id);
        findItem.setName(book.getName());
        findItem.setAuthor(book.getAuthor());
        findItem.setIsbn(book.getIsbn());
        findItem.setPublisher(book.getPublisher());
        findItem.setCategory(book.getCategory());
        findItem.setStockQuantity(book.getStockQuantity());
        findItem.setRentalPrice(book.getRentalPrice());

    }

    public List<Item> findAllItem()
    {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId)
    {
        return itemRepository.findOne(itemId);
    }

}
