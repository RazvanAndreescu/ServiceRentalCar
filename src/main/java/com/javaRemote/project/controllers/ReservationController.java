package com.javaRemote.project.controllers;

import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.database.entities.Reservation;
import com.javaRemote.project.service.ReservationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/listAll")
    public List<Reservation> printAllCustomers(){
        return reservationService.getAllReservation();
    }
}
