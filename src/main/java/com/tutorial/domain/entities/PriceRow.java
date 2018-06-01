package com.tutorial.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "price_row")
@NamedQueries({
        @NamedQuery(name = "PriceRow.getPriceRowByPriceAndCurrencyAndProductAndIsActive", query = "select pr from PriceRow pr where pr.price = :price and pr.currency like :currency and pr.product like :product and pr.active = true"),
        @NamedQuery(name = "PriceRow.getPriceRowByPriceAndCurrencyAndNullProductAndIsActive", query = "select pr from PriceRow pr where pr.price = :price and pr.currency like :currency and pr.product is null and pr.active = true"),
        @NamedQuery(name = "PriceRow.getAllDisablePriceRows", query = "select pr from PriceRow pr where pr.active = false "),
        @NamedQuery(name = "PriceRow.getAllNoProductPriceRows", query = "select pr from PriceRow pr where pr.product is null")
})

public class PriceRow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public PriceRow() {
    }

    public PriceRow(double price, Currency currency, boolean active) {
        this.price = price;
        this.currency = currency;
        this.active = active;
    }

    public PriceRow(double price, Currency currency, Product product, boolean active) {
        this.currency = currency;
        this.active = active;
        this.product = product;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
