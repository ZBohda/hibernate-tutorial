package com.tutorial.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "currency")
@NamedQuery(name = "Currency.getAll", query = "select c from Currency c")
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "code")
    private String code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
