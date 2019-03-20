package com.example.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarEquipmentId implements Serializable {

    @Column(name = "carid")
    private long carid;

    @Column(name = "equipmentid")
    private long equipmentid;

    public CarEquipmentId () {}
    public CarEquipmentId (Long carid, Long equipmentid){
        this.carid = carid;
        this.equipmentid = equipmentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEquipmentId that = (CarEquipmentId) o;
        return carid == that.carid &&
                equipmentid == that.equipmentid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carid, equipmentid);
    }
}
