package Goldra9.library.repository;

import Goldra9.library.domain.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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

        List<Rental> result = em.createQuery("select r from Rental r" +
                        " join fetch r.member m", Rental.class)
                .getResultList();
        return result;
    }

}
