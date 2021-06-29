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
    public List<Reservation> printAllCustomers() {
        return reservationService.getAllReservation();
    }

    @PostMapping("/")
    @ResponseBody
    public Reservation crateReservation(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @PutMapping("/{reservationId}")
    @ResponseBody
    public boolean updateReservation(@PathVariable int reservationId, @RequestBody Reservation reservationDto) {
        Reservation reservationBeforeUpdate = new Reservation(reservationService.getReservationById(reservationId));

        if (reservationService.getReservationById(reservationId) == null) {
            return false;
        }

        return !reservationService.updateReservation(reservationId, reservationDto).equals(reservationBeforeUpdate);
    }

    @DeleteMapping("/{reservationId}")
    @ResponseBody
    public boolean deleteReservation(@PathVariable int reservationId) {
        if (reservationService.getReservationById(reservationId) != null) {
            reservationService.deleteReservationById(reservationId);
            return true;
        }
        return false;
    }

}
