package com.vin.learn.repositories.postgres;

import com.vin.learn.entities.postgres.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
