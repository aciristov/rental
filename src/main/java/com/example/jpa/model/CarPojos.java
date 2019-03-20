package com.example.jpa.model;

import java.util.List;

public class CarPojos {

//    private String brand;
//    private String model;
//    private int production_year;
    private int mileage;
    private String color;
    private List<CarEquPojos> equipments;

    public CarPojos(){}
    public CarPojos(
//            String brand, String model, int production_year,
            int mileage, String color, List<CarEquPojos> equipments){
//        this.brand = brand;
//        this.model = model;
//        this.production_year = production_year;
        this.mileage = mileage;
        this.color = color;
        this.equipments = equipments;
    }

//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public int getProduction_year() {
//        return production_year;
//    }
//
//    public void setProduction_year(int production_year) {
//        this.production_year = production_year;
//    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<CarEquPojos> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<CarEquPojos> equipments) {
        this.equipments = equipments;
    }
}
