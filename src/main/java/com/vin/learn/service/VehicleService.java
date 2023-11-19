package com.vin.learn.service;

import com.vin.learn.entities.postgres.Vehicle;
import com.vin.learn.model.VehicleDTO;
import com.vin.learn.repositories.postgres.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional("postgresTransactionManager")
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDTO> getAllVehicles() {
        List<VehicleDTO> result = new ArrayList<>();
        final List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (!vehicleList.isEmpty()) {
            vehicleList.forEach(v -> {
                VehicleDTO vehicleDTO = new VehicleDTO(v.getVehicleId(), v.getVin(), v.getCategory(),
                        v.getColor(), v.getCompany(), v.getModel(), v.getYear());
                result.add(vehicleDTO);
            });
        }
        return result;
    }
}
