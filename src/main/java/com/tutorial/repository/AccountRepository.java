package com.tutorial.repository;

import com.tutorial.domain.entities.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccountRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public long create(Account account) {
        em.persist(account);
        em.flush();
        return account.getId();
    }

    @Transactional(readOnly = true)
    public Account read(long id) {
        return em.find(Account.class, id);
    }

    @Transactional
    public void update(Account account) {
        em.merge(account);
        em.flush();
    }

    @Transactional
    public void delete(long id) {
        em.remove(em.find(Account.class, id));
    }
}
