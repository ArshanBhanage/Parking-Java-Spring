package com.example.parkinglot.service;

import com.example.parkinglot.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ParkingLotManager {
    private final List<Slot> slots = new ArrayList<>();

    public void initializeSlots(int totalSlots) {
        slots.clear();
        for (int i = 0; i < totalSlots; i++) {
            SlotSize size = getSlotSizeByIndex(i, totalSlots);
            slots.add(new Slot(i + 1, size));
        }
    }

    private SlotSize getSlotSizeByIndex(int index, int total) {
        int segment = total / 3;
        if (index < segment) return SlotSize.SMALL;
        else if (index < 2 * segment) return SlotSize.LARGE;
        else return SlotSize.OVERSIZE;
    }

    public String parkVehicle(Vehicle vehicle) {
        for (Slot slot : slots) {
            if (slot.canFit(vehicle.getSize())) {
                slot.park(vehicle);
                return "Parked at slot " + slot.getId();
            }
        }
        return "No available slot for vehicle size: " + vehicle.getSize();
    }

    public String exitVehicle(String plateNumber) {
        for (Slot slot : slots) {
            Vehicle v = slot.getVehicle();
            if (v != null && v.getPlateNumber().equalsIgnoreCase(plateNumber)) {
                slot.leave();
                return "Vehicle " + plateNumber + " has exited from slot " + slot.getId();
            }
        }
        return "Vehicle not found.";
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
