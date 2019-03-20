package com.example.jpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.soap.Text;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentalid")
    private Long id;

    @NotNull
    private Date start_date;

    @NotNull
    private Date end_date;

    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("customerid")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "carid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("carid")
    private Car car;

    // TODO: fix PICK_UP_LOCATION AND DROP_OFF_LOCATION

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locationid")
    @JsonProperty("locationid")
    private Location location;

    private Rental(){}
    private Rental(Date start_date, Date end_date, String remarks){
        this.start_date = start_date;
        this.end_date = end_date;
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id) &&
                Objects.equals(start_date, rental.start_date) &&
                Objects.equals(end_date, rental.end_date) &&
                Objects.equals(remarks, rental.remarks) &&
                Objects.equals(customer, rental.customer) &&
                Objects.equals(car, rental.car) &&
                Objects.equals(location, rental.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_date, end_date, remarks, customer, car, location);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
