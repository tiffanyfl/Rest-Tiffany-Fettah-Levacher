package com.example.essai.data;

public class Car {
    private String plateNumber;
    private boolean rent;
    private Dates datesRent;

    public Car() {

    }

    public Car(String plateNumber, boolean rent) {
        this.plateNumber = plateNumber;
        this.rent = rent;
        this.datesRent = null;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public boolean getRent() {
        return this.rent;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public Dates getDatesRent() {
        return this.datesRent;
    }

    public void setDatesRent(Dates dates) {
        this.datesRent = dates;
    }
}
