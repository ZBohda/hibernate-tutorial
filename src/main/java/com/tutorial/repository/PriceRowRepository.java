package com.tutorial.repository;

import com.tutorial.domain.entities.Currency;
import com.tutorial.domain.entities.PriceRow;
import com.tutorial.domain.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PriceRowRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public long create(PriceRow priceRow) {
        em.persist(priceRow);
        em.flush();
        return priceRow.getId();
    }

    public PriceRow read(long id) {
        return em.find(PriceRow.class, id);
    }

    @Transactional
    public void delete(long id) {
        em.remove(em.find(PriceRow.class, id));
    }

    @Transactional
    public void update(PriceRow priceRow) {
        em.merge(priceRow);
        em.flush();
    }


    public PriceRow getPriceRowByPriceAndCurrencyAndProduct(double price, Currency currency, Product product) {
        return em.createNamedQuery("PriceRow.getPriceRowByPriceAndCurrencyAndProductAndIsActive", PriceRow.class).setParameter("price", price).setParameter("currency", currency).setParameter("product", product).getSingleResult();
    }

    public PriceRow getPriceRowByPriceAndCurrency(double price, Currency currency){
        return em.createNamedQuery("PriceRow.getPriceRowByPriceAndCurrencyAndNullProductAndIsActive", PriceRow.class).setParameter("price", price).setParameter("currency", currency).getSingleResult();
    }

    public List<PriceRow> getAllDisabledPriceRows(){
        return em.createNamedQuery("PriceRow.getAllDisablePriceRows", PriceRow.class).getResultList();
    }

    public List<PriceRow> getAllNoProductPriceRows(){
        return em.createNamedQuery("PriceRow.getAllNoProductPriceRows", PriceRow.class).getResultList();
    }

}
