package com.javaRemote.project.controllers;

import com.javaRemote.project.database.dto.ReservationDto;
import com.javaRemote.project.database.entities.Reservation;
import com.javaRemote.project.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/")
    @ResponseBody
    public Reservation crateReservation(@RequestBody @Valid ReservationDto reservationDto) {
        return reservationService.create(reservationDto);
    }

    @GetMapping("/")
    public List<ReservationDto> printAllCustomers() {
        return reservationService.getAllReservation();
    }

    @PutMapping("/{reservationId}")
    @ResponseBody
    public boolean updateReservation(@PathVariable int reservationId, @RequestBody ReservationDto reservationDto) {
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
