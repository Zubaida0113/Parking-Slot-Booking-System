package com.parking.parkingapp.repository;

import com.parking.parkingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // You can define custom query methods here if needed.
    // For example:
    User findByEmail(String email);
}


