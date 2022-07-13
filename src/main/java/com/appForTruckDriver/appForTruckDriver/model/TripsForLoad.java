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
public class TripsForLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tripNumber;
    private Integer boxQuantity;
    private LocalDate date;
    private Integer allowedHeightInPallet;
    private Integer palletsForTrip;
    private Double rowHeight;
    @ManyToOne
    @JoinColumn(name = "cargoId")
    @JsonBackReference
    private Cargo cargo;
}
