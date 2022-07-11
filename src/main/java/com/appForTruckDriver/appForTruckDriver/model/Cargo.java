package com.appForTruckDriver.appForTruckDriver.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String date;

    @ManyToOne
    @JoinColumn(name = "truckId")
    @JsonBackReference
    private Truck truck;

    @OneToMany(mappedBy = "cargo")
    @JsonManagedReference
    private List<TripsForLoad> tripsForLoads;


}
