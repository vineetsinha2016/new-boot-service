package com.vin.learn.controller;


import com.vin.learn.model.VehicleDTO;
import com.vin.learn.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/v1")
@Slf4j
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(value = "/vehicles", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<?> getVehicles(@RequestHeader HttpHeaders headers)
            throws Exception
    {
        List<VehicleDTO> vehicleDTOS = vehicleService.getAllVehicles();
        //ServiceResponse<List<VehicleDTO>> response = new ServiceResponse<>();
        //response.setData(items);
        return new ResponseEntity<>(vehicleDTOS, HttpStatus.OK);
    }
}
