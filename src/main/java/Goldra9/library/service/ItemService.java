package Goldra9.library.service;

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
    public Item updateItem(Long id, Book book)
    {
        Item findItem = itemRepository.findOne(id);
        Book updateBook = new Book(book.getName(), book.getRentalPrice(), book.getStockQuantity(), book.getCategory(), book.getAuthor(), book.getPublisher(), book.getIsbn());
        return updateBook;
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
