package com.parking.parkingapp.controller;

import com.parking.parkingapp.model.ParkingSlot;
import com.parking.parkingapp.service.ParkingSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
public class ParkingSlotController {

    private final ParkingSlotService service;

    public ParkingSlotController(ParkingSlotService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ParkingSlot> addSlot(@RequestBody ParkingSlot slot) {
        ParkingSlot createdSlot = service.createSlot(slot);  // Corrected method name here
        return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<ParkingSlot>> getAvailable() {
        List<ParkingSlot> availableSlots = service.getAvailableSlots();
        return new ResponseEntity<>(availableSlots, HttpStatus.OK);
    }

    @PostMapping("/book/{slotId}/user/{userId}")
    public ResponseEntity<String> book(@PathVariable Long slotId, @PathVariable Long userId) {
        String message = service.bookSlot(slotId, userId);  // Updated to return message
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/release/{slotId}")
    public ResponseEntity<String> release(@PathVariable Long slotId) {
        String message = service.releaseSlot(slotId);  // Added to call releaseSlot method
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}