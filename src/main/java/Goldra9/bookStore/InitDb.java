package Goldra9.bookStore;

import Goldra9.bookStore.domain.*;
import Goldra9.bookStore.domain.item.Book;
import Goldra9.bookStore.domain.item.Item;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
@Transactional
public class InitDb
{
    private final InitService initService;
    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        public void dbInit1()
        {

            Member member = new Member("name", new Address("도시", "스트릿", "우편번호"), "010-1234-567", "sdflksejf", "111123");
            em.persist(member);

            Book book = new Book("정처기",1000,10,"길벗", "시나공", 12345);

            em.persist(book);

            Category category1 = new Category("전문서적");
            Category category2 = new Category("소설");
            em.persist(category1);
            em.persist(category2);

//            RentalItem rentalItem1 = RentalItem.createRentalItem(book, 1000, 1);
//            Rental rental = Rental.createRental(member, rentalItem1);
//            em.persist(rental);

//            CategoryItem categoryItem = CategoryItem.createCategoryItem(book, category1);
//            Item item = Item.createItem(categoryItem);
//            em.persist(item);



        }
    }


}
