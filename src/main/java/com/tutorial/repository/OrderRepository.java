package com.tutorial.repository;

import com.tutorial.domain.entities.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public long create(Order order) {
        em.persist(order);
        em.flush();
        return order.getId();
    }

    public Order read(long id) {
        return em.find(Order.class, id);
    }

    @Transactional
    public void update(Order order) {
        em.merge(order);
        em.flush();
    }

    @Transactional
    public void delete(long id) {
        em.remove(em.find(Order.class, id));
    }

}
