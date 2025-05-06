package com.parking.parkingapp.model;

import com.parking.parkingapp.model.User;
import jakarta.persistence.*;

@Entity
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slotNumber;

    private boolean isAvailable = true;

    @ManyToOne
    @JoinColumn(name = "user_id") // optional but recommended to control FK name
    private User user; // Nullable — assigned if booked

    // Constructors
    public ParkingSlot() {
    }

    public ParkingSlot(String slotNumber, boolean isAvailable, User user) {
        this.slotNumber = slotNumber;
        this.isAvailable = isAvailable;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
