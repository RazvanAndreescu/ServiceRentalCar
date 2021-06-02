package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Reservation;
import com.javaRemote.project.database.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //Create
    public Reservation create(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    //Read
    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationByStartDate(Date startDate){
        return reservationRepository.getReservationByStartDate(startDate);
    }

    public List<Reservation> getReservationByEndDate(Date endDate){
        return reservationRepository.getReservationByEndDate(endDate);
    }

    public List<Reservation> getReservationByPrice(int price){
        return reservationRepository.getReservationByPrice(price);
    }

    //Update
    public Reservation updateReservationStartDate(int id, Date startDate){
        Reservation reservation = reservationRepository.getById(id);
        reservation.setStartDate(startDate);
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservationEndDate(int id, Date endDate){
        Reservation reservation = reservationRepository.getById(id);
        reservation.setEndDate(endDate);
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservationPrice(int id, int price){
        Reservation reservation = reservationRepository.getById(id);
        reservation.setPrice(price);
        return reservationRepository.save(reservation);
    }

    //Delete
    public void deleteReservation(Reservation reservation){
        reservationRepository.delete(reservation);
    }

    public void deleteReservationById(int id){
        reservationRepository.deleteById(id);
    }
}
