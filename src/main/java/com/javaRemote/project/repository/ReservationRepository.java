package com.javaRemote.project.repository;

import com.javaRemote.project.database.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> getReservationByStartDate(Date startDate);
    List<Reservation> getReservationByEndDate(Date endDate);
    List<Reservation> getReservationByPrice(int price);
}
