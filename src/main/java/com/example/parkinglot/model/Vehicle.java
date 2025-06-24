package com.example.parkinglot.model;

public class Vehicle {
    private String plateNumber;
    private SlotSize size;

    public Vehicle(String plateNumber, SlotSize size) {
        this.plateNumber = plateNumber;
        this.size = size;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public SlotSize getSize() {
        return size;
    }
}
