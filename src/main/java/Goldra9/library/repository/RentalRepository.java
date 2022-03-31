package Goldra9.library.repository;

import Goldra9.library.domain.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RentalRepository
{
    private final EntityManager em;

    public void save(Rental rental)
    {
        em.persist(rental);
    }

    public Rental findOne(Long id)
    {
        return em.find(Rental.class, id);
    }

    public List<Rental> findAll()
    {
        List<Rental> result = em.createQuery("select r from Rental r"+
                        " join fetch r.member m" +
                        " join fetch r.rentalItemList ri" +
                        " join fetch ri.item i", Rental.class)
                .getResultList();
        return result;
    }

    public List<Rental> findWithMember(RentalSearch rentalSearch)
    {
        String jpql =
                "select r from Rental r" +
                " join fetch r.member m" +
                " join fetch r.rentalItemList ri" +
                " join fetch ri.item i" +
                " join fetch i.category c";
        boolean isFirstCondition = true;

        //주문 상태 검색
        if (rentalSearch.getRentalStatus() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " r.rentalStatus = :rentalStatus";
        }

        //회원 이름 검색
        if (StringUtils.hasText(rentalSearch.getMemberName())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        //== 카테고리 검색 ==//
        if(StringUtils.hasText(rentalSearch.getCategoryName()))
        {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " c.name like :name";
        }



        TypedQuery<Rental> query = em.createQuery(jpql, Rental.class)
                .setMaxResults(1000);

        if (rentalSearch.getRentalStatus() != null) {
            query = query.setParameter("rentalStatus", rentalSearch.getRentalStatus());
        }
        if (StringUtils.hasText(rentalSearch.getMemberName())) {
            query = query.setParameter("name", rentalSearch.getMemberName());
        }
        if (StringUtils.hasText(rentalSearch.getCategoryName())) {
            query = query.setParameter("name", rentalSearch.getCategoryName());
        }

        return query.getResultList();
    }

}
