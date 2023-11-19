package com.vin.learn.model;
public record VehicleDTO (

    String vehicleId,
    String vin,
    String category,
    String color,
    String company,
    String model,
    String year
) {}
