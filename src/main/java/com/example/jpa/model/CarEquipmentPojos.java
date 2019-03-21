package com.example.jpa.model;

import java.util.Date;

public class CarEquipmentPojos {


    private long equipmentid;
    private String color;
    private String name;
    private int mileage;
    private Date start_date;
    private Date end_date;

    public CarEquipmentPojos(){}
    public CarEquipmentPojos(Long equipmentid, String name, Date start_date, Date end_date){
        this.equipmentid = equipmentid;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public long getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(long equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
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
