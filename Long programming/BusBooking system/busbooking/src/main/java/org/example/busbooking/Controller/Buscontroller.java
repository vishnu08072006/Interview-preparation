package org.example.busbooking.Controller;

import org.example.busbooking.Entity.Bus;
import org.example.busbooking.Service.Busservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@CrossOrigin
public class Buscontroller {

    @Autowired
    public Busservice service;

    @GetMapping("/init")
    public String initSeats() {
        service.initializeSeats();
        return "Seats Initialized";
    }

    @GetMapping("/seats")
    public List<Bus> getSeat() {
        return service.getSeats();
    }

    @PostMapping("/book/{seatNo}/{name}")
    public String bookseat(@PathVariable int seatNo, @PathVariable String name) {
        return service.bookSeat(seatNo, name);
    }

    @PostMapping("/cancel/{seatNo}")
    public String cancelseat(@PathVariable int seatNo) {
        return service.cancelSeat(seatNo);
    }
}