package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.ReservationDto;
import com.javaRemote.project.database.entities.Reservation;
import com.javaRemote.project.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ConvertorService convertorService;

    public ReservationService(ReservationRepository reservationRepository, ConvertorService convertorService) {
        this.reservationRepository = reservationRepository;
        this.convertorService = convertorService;
    }

    public Reservation create(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int id){
        return reservationRepository.findReservationByReservationId(id);
    }

    public List<Reservation> getAllReservationsForACustomer(int id){
        return reservationRepository.findReservationsByCustomer_CustomerId(id);
    }

    public List<ReservationDto> getAllReservationDto(){
        List<ReservationDto> reservationDtoList= new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findAll();
        for (Reservation reservation: reservationList){
            reservationDtoList.add(convertorService.convertToReservationDto(reservation));
        }
        return reservationDtoList;
    }

    public Reservation updateReservation(int id, Reservation jsonReservation){
        Reservation databaseReservation = reservationRepository.findReservationByReservationId(id);
        databaseReservation
                .setStartDate(jsonReservation.getStartDate() != null ? jsonReservation.getStartDate():databaseReservation.getStartDate())
                .setEndDate(jsonReservation.getEndDate() != null ? jsonReservation.getEndDate() : databaseReservation.getEndDate())
                .setPrice(jsonReservation.getPrice() != 0 ? jsonReservation.getPrice() : databaseReservation.getPrice())
                .setBranch(jsonReservation.getBranch() != null ? jsonReservation.getBranch() : databaseReservation.getBranch())
                .setCustomer(jsonReservation.getCustomer() != null ? jsonReservation.getCustomer() : databaseReservation.getCustomer())
                .setCar(jsonReservation.getCar() != null ? jsonReservation.getCar() : databaseReservation.getCar());
        return reservationRepository.save(databaseReservation);
    }

    public void deleteReservationById(int id){
        reservationRepository.deleteById(id);
    }
}
