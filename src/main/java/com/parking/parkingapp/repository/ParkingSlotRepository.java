package com.parking.parkingapp.repository;

import com.parking.parkingapp.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

    // Optional custom query methods

    List<ParkingSlot> findByIsAvailableTrue(); // Get all available slots

    List<ParkingSlot> findByUserId(Long userId); // Get slots booked by a specific user
}
