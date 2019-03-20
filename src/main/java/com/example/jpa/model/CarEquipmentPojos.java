package com.example.jpa.model;

public class CarEquipmentPojos {


    private long equipmentid;
    private String color;
    private String name;
    private int mileage;

    public CarEquipmentPojos(){}
    public CarEquipmentPojos(Long equipmentid, String color, String name, int mileage){
        this.equipmentid = equipmentid;
        this.color = color;
        this.name = name;
        this.mileage = mileage;
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
}
