package org.example.busbooking.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bus_seats")
public class Bus {

    @Id
    private int seatNumber;

    @Column(nullable = false)
    private boolean booked;

    private String userName;


}