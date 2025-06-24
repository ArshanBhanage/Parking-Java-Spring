package com.example.parkinglot.controller;

import com.example.parkinglot.model.Slot;
import com.example.parkinglot.model.SlotSize;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.service.ParkingLotManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParkingLotController {

    @Autowired
    private ParkingLotManager manager;

    @PostMapping("/init")
    public String initialize(@RequestParam int totalSlots) {
        manager.initializeSlots(totalSlots);
        return "Initialized " + totalSlots + " slots.";
    }

    @PostMapping("/park")
    public String park(@RequestParam SlotSize size, @RequestParam String plate) {
        return manager.parkVehicle(new Vehicle(plate, size));
    }

    @PostMapping("/exit")
    public String exit(@RequestParam String plate) {
        return manager.exitVehicle(plate);
    }

    @GetMapping("/status")
    public List<Slot> status() {
        return manager.getSlots();
    }
}
