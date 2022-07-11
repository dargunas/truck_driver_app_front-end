package com.appForTruckDriver.appForTruckDriver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "cargoId")
    @JsonBackReference
    private Cargo cargo;
}
