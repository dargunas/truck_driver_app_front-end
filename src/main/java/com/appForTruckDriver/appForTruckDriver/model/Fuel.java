package com.appForTruckDriver.appForTruckDriver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double dieselFuel;
    private Double adblue;
    private LocalDate date;
    private Long startKilometers;
    private Long endKilometers;

    @ManyToOne
    @JoinColumn(name = "truckId")
    @JsonBackReference
    private Truck truck;
}