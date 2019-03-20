package com.example.jpa.model;

import java.util.Date;

public class CarEquPojos {

    private Long equipmentid;
    private String brand;
    private String model;
    private int production_year;
    private Date start_date;
    private Date end_date;

    public CarEquPojos(){}
    public CarEquPojos(Long equipmentid, String brand, String model, int production_year, Date start_date, Date end_date){
        this.equipmentid = equipmentid;
        this.brand = brand;
        this.model = model;
        this.production_year = production_year;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Long getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(Long equipmentid) {
        this.equipmentid = equipmentid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProduction_year() {
        return production_year;
    }

    public void setProduction_year(int production_year) {
        this.production_year = production_year;
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
