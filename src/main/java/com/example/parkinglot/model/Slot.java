package com.example.parkinglot.model;

public class Slot {
    private int id;
    private SlotSize size;
    private Vehicle vehicle;

    public Slot(int id, SlotSize size) {
        this.id = id;
        this.size = size;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFit(SlotSize vehicleSize) {
        return isAvailable() && this.size.ordinal() >= vehicleSize.ordinal();
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void leave() {
        this.vehicle = null;
    }

    public int getId() {
        return id;
    }

    public SlotSize getSize() {
        return size;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
