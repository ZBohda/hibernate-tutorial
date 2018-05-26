package com.tutorial.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private Set<PriceRow> prices;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PriceRow> getPrices() {
        return prices;
    }

    public void setPrices(Set<PriceRow> prices) {
        this.prices = prices;
    }
}
