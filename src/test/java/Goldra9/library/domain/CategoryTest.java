package Goldra9.library.domain;

import Goldra9.library.controller.form.CategoryForm;
import Goldra9.library.domain.item.Book;
import Goldra9.library.repository.CategoryRepository;
import Goldra9.library.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class CategoryTest {
    CategoryRepository categoryRepository;
    ItemRepository itemRepository;

    @Test
    void totalPrice()
    {

    }
}