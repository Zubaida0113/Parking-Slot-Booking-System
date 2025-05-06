package com.parking.parkingapp.service;

import com.parking.parkingapp.model.ParkingSlot;
import com.parking.parkingapp.model.User;
import com.parking.parkingapp.repository.ParkingSlotRepository;
import com.parking.parkingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSlotService {

    private final ParkingSlotRepository parkingSlotRepository;
    private final UserRepository userRepository;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository, UserRepository userRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.userRepository = userRepository;
    }

    public List<ParkingSlot> getAllSlots() {
        return parkingSlotRepository.findAll();
    }

    public List<ParkingSlot> getAvailableSlots() {
        return parkingSlotRepository.findByIsAvailableTrue();
    }

    // Updated bookSlot method to return a message
    public String bookSlot(Long slotId, Long userId) {
        Optional<ParkingSlot> slotOpt = parkingSlotRepository.findById(slotId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (slotOpt.isPresent() && userOpt.isPresent()) {
            ParkingSlot slot = slotOpt.get();
            if (!slot.isAvailable()) {
                return "Slot already booked";
            }

            slot.setAvailable(false);
            slot.setUser(userOpt.get());

            parkingSlotRepository.save(slot);
            return "Slot booked successfully";
        }

        return "Slot or user not found";
    }

    public ParkingSlot createSlot(ParkingSlot slot) {
        return parkingSlotRepository.save(slot);
    }

    // Add the releaseSlot method here
    public String releaseSlot(Long slotId) {
        Optional<ParkingSlot> slotOpt = parkingSlotRepository.findById(slotId);

        if (slotOpt.isPresent()) {
            ParkingSlot slot = slotOpt.get();
            slot.setAvailable(true);
            slot.setUser(null);  // Remove the user from the slot

            parkingSlotRepository.save(slot);
            return "Slot released successfully";
        }

        return "Slot not found";
    }
}