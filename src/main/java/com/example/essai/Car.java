package com.example.essai;

public class Car {
    private String plateNumber;
    private boolean rent;

    public Car(String plateNumber, boolean rent) {
        this.plateNumber = plateNumber;
        this.rent = rent;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public boolean getRent() {
        return this.rent;
    }

    public String setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this.plateNumber;
    }

    public boolean setRent(boolean rent) {
        this.rent = rent;
        return this.rent;
    }
}
