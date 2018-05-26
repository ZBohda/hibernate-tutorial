package com.tutorial.domain.entities;

import com.tutorial.domain.enums.OrderState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "creation_time")
    private Date creationTime;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @OneToMany(mappedBy = "order")
    private Set<OrderEntry> entries;

    @ManyToOne
    @JoinColumn(name = "order_customer_id")
    private Customer customer;

    @Column(name = "total_price")
    private double totalPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Set<OrderEntry> getEntries() {
        return entries;
    }

    public void setEntries(Set<OrderEntry> entries) {
        this.entries = entries;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
