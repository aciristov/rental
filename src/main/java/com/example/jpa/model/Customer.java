package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private Long customerid;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private Date birth_date;

    private String driver_licence_number;

    private Customer(){}
    private Customer(String name, Date birth_date, String driver_licence_number){
        this.name = name;
        this.birth_date = birth_date;
        this.driver_licence_number = driver_licence_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerid, customer.customerid) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(birth_date, customer.birth_date) &&
                Objects.equals(driver_licence_number, customer.driver_licence_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerid, name, birth_date, driver_licence_number);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getDriver_licence_number() {
        return driver_licence_number;
    }

    public void setDriver_licence_number(String driver_licence_number) {
        this.driver_licence_number = driver_licence_number;
    }

    public String getPassword() {
        return password;
    }
}
