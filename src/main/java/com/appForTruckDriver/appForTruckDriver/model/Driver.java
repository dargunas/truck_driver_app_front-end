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
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Truck> trucks;
    @ManyToOne
    @JoinColumn(name = "workDayId")
    @JsonBackReference
    private WorkDay workDay;


}
