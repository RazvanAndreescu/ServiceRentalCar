package com.javaRemote.project.repository;

import com.javaRemote.project.database.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findReservationByReservationId(int id);

    List<Reservation> findReservationsByCustomer_CustomerId(int customerId);

    List<Reservation> findReservationsByCar_CarId(int carId);

    List<Reservation> findReservationsByBranch_BranchId(int branchId);
}
