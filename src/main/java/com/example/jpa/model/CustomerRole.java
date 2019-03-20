package com.example.jpa.model;

import javax.persistence.*;

@Entity
@Table(name = "customer_roles")
public class CustomerRole {

    @Id
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "role")
    private String name;

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
