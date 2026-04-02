package org.example.busbooking.Service;

import org.example.busbooking.Entity.Bus;
import org.example.busbooking.Repository.Busrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Busservice {

    @Autowired
    private Busrepository repo;

    public void initializeSeats() {
        if (repo.count() == 0) {
            for (int i = 1; i <= 30; i++) {
                Bus seat = new Bus();
                seat.setSeatNumber(i);
                seat.setBooked(false);
                repo.save(seat);
            }
        }
    }

    public List<Bus> getSeats() {
        return repo.findAll();
    }

    public String bookSeat(int seatNo, String name) {
        Bus seat = repo.findById(seatNo).orElse(null);

        if (seat != null && !seat.isBooked()) {
            seat.setBooked(true);
            seat.setUserName(name);
            repo.save(seat);
            return "Seat Booked Successfully";
        }
        return "Seat Already Booked";
    }

    public String cancelSeat(int seatNo) {
        Bus seat = repo.findById(seatNo).orElse(null);

        if (seat != null && seat.isBooked()) {
            seat.setBooked(false);
            seat.setUserName(null);
            repo.save(seat);
            return "Booking Cancelled";
        }
        return "Seat Not Booked";
    }
}