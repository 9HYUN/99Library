package Goldra9.bookStore.repository;

import Goldra9.bookStore.domain.Rental;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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




}
