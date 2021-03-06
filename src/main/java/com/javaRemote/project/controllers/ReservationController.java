package com.javaRemote.project.controllers;

import com.javaRemote.project.database.entities.Reservation;
import com.javaRemote.project.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/")
    public List<Reservation> printAllCustomers(){
        return reservationService.getAllReservation();
    }

    @PostMapping("/")
    @ResponseBody
    public Reservation crateReservation(@RequestBody Reservation reservation){
        return reservationService.create(reservation);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean updateReservation(@PathVariable int id, @RequestBody Reservation reservation){
        if(reservationService.getReservationById(id) != null){
            reservationService.updateReservation(id, reservation);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteReservation(@PathVariable int id){
        if(reservationService.getReservationById(id) != null){
            reservationService.deleteReservationById(id);
            return true;
        }
        return false;
    }

}
