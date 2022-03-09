package Goldra9.bookStore;

import Goldra9.bookStore.domain.*;
import Goldra9.bookStore.domain.item.Book;
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
            Member member = new Member("name", new Address("111", "222", "333"), "elkfj", "sdflksejf", "111123");
            em.persist(member);

            Book book = new Book("정보처리기사", 1000,10,"길벗","시나공",123452);
            em.persist(book);

            Category category = new Category("전문서적");
            em.persist(category);

            RentalItem rentalItem1 = RentalItem.createRentalItem(book, 1000, 1);
            Rental rental = Rental.createRental(member, rentalItem1);
            em.persist(rental);

        }
    }


}
