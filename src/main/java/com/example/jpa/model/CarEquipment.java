package com.example.jpa.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "car_equipment")
public class CarEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "carid")
    private long carid;

    @Column(name = "equipmentid")
    private long equipmentid;

    private Date start_date;

    private Date end_date;

    public CarEquipment(){}
    public CarEquipment(long id, long carid, long equipmentid, Date start_date, Date end_date){
        this.id = id;
        this.carid = id;
        this.equipmentid = equipmentid;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEquipment that = (CarEquipment) o;
        return id == that.id &&
                carid == that.carid &&
                equipmentid == that.equipmentid &&
                Objects.equals(start_date, that.start_date) &&
                Objects.equals(end_date, that.end_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carid, equipmentid, start_date, end_date);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarid() {
        return carid;
    }

    public void setCarid(long carid) {
        this.carid = carid;
    }

    public long getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(long equipmentid) {
        this.equipmentid = equipmentid;
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
}
