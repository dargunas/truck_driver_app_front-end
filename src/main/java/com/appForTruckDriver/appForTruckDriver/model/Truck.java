package com.appForTruckDriver.appForTruckDriver.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numberPlate;
    @ManyToOne
    @JoinColumn(name = "driverId")
    @JsonBackReference
    private Driver driver;

    @OneToMany(mappedBy = "truck", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Cargo> cargos;


    @OneToMany(mappedBy = "truck", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Fuel> fuels;
}

