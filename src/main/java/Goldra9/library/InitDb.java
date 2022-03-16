package Goldra9.library;

import Goldra9.library.domain.*;
import Goldra9.library.domain.item.Book;
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

            Member member1 = new Member("name", new Address("도시", "스트릿", "우편번호"), "010-1234-567", "sdflksejf", "111123");
            em.persist(member1);
            Member member2 = new Member("name2", new Address("도2시", "스트릿2", "우편번2호"), "010-1234-2222", "sdfl2222", "12222");
            em.persist(member2);
            Member member3 = new Member("name3", new Address("도3시", "스트릿3", "우편번3호"), "010-1234-3333", "sdfl3333", "3333");
            em.persist(member3);

            Category category1 = new Category("전문서적");
            Category category2 = new Category("소설");
            Category category3 = new Category("소설3");
            em.persist(category1);
            em.persist(category2);
            em.persist(category3);

            Book book1 = new Book("정처기",1000,10,category1, "시나공", "길벗",123);
            Book book2 = new Book("정처기2",1000,5,category2, "시나공", "길벗2",345);
            em.persist(book1);
            em.persist(book2);



//            RentalItem rentalItem1 = RentalItem.createRentalItem(book, 1000, 1);
//            Rental rental = Rental.createRental(member, rentalItem1);
//            em.persist(rental);

//            CategoryItem categoryItem = CategoryItem.createCategoryItem(book, category1);
//            Item item = Item.createItem(categoryItem);
//            em.persist(item);



        }
    }


}
