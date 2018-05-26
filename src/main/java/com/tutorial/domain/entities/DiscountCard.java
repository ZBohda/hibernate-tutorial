package com.tutorial.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "discount_card")
public class DiscountCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "discount_points")
    private int discountPoints;

    @Column(name = "creation_time")
    private Date creationTime;

    @Column(name = "expiration_time")
    private Date expirationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDiscountPoints() {
        return discountPoints;
    }

    public void setDiscountPoints(int discountPoints) {
        this.discountPoints = discountPoints;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }
}
