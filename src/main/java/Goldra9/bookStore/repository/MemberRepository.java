package Goldra9.bookStore.repository;

import Goldra9.bookStore.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository
{
    @PersistenceContext
    private final EntityManager em;

    public void save(Member member)
    {
        em.persist(member);
    }

    public Member findOne(Long id)
    {
        return em.find(Member.class, id);
    }

    public List<Member> findAll()
    {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name)
    {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Member> findByPersonNumber(String personNumber)
    {
        return em.createQuery("select m from Member m where m.personNumber = :personNumber", Member.class)
                .setParameter("personNumber", personNumber)
                .getResultList();
    }
}
