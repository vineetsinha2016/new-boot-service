package com.vin.learn.entities.postgres;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="vehicle")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "vehicleId")
@Getter
@Setter
public class Vehicle implements Serializable {
    @Id
    @Column(name = "vehicleid")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String vehicleId;

    @Column(name = "vin")
    private String vin;

    @Column(name = "category")
    private String category;

    @Column(name = "color")
    private String color;
    @Column(name = "company")
    private String company;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private String year;

}
