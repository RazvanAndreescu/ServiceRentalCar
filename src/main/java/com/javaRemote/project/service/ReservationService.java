package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.ReservationDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Car;
import com.javaRemote.project.database.entities.Customer;
import com.javaRemote.project.database.entities.Reservation;
import com.javaRemote.project.repository.BranchRepository;
import com.javaRemote.project.repository.CarRepository;
import com.javaRemote.project.repository.CustomerRepository;
import com.javaRemote.project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final BranchRepository branchRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              BranchRepository branchRepository,
                              CustomerRepository customerRepository,
                              CarRepository carRepository) {

        this.reservationRepository = reservationRepository;
        this.branchRepository = branchRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
    }

    public Reservation create(ReservationDto reservationDto) {
        return reservationRepository.save(convertReservationDtoToReservation(reservationDto));
    }

    public List<ReservationDto> getAllReservation() {
        List<ReservationDto> reservationDtoList = new ArrayList<>();

        for (Reservation reservation : reservationRepository.findAll()) {
            reservationDtoList.add(convertReservationToReservationDto(reservation));
        }

        return reservationDtoList;
    }

    public Reservation getReservationById(int reservationId) {
        return reservationRepository.findReservationByReservationId(reservationId);
    }

    public Reservation updateReservation(int reservationId, ReservationDto reservationDto) {
        Reservation reservationToUpdate = reservationRepository.findReservationByReservationId(reservationId);
        Reservation inputReservation = convertReservationDtoToReservation(reservationDto);

        reservationToUpdate
                .setStartDate(Date.valueOf(inputReservation.getStartDate() != null ? inputReservation.getStartDate() : reservationToUpdate.getStartDate()))
                .setEndDate(Date.valueOf(inputReservation.getEndDate() != null ? inputReservation.getEndDate() : reservationToUpdate.getEndDate()))
                .setPrice(inputReservation.getPrice() != null ? inputReservation.getPrice() : reservationToUpdate.getPrice())
                .setBranch(inputReservation.getBranch() != null ? inputReservation.getBranch() : reservationToUpdate.getBranch())
                .setCustomer(inputReservation.getCustomer() != null ? inputReservation.getCustomer() : reservationToUpdate.getCustomer())
                .setCar(inputReservation.getCar() != null ? inputReservation.getCar() : reservationToUpdate.getCar());

        return reservationRepository.save(reservationToUpdate);
    }

    public void deleteReservationById(int id) {
        reservationRepository.deleteById(id);
    }

    public Reservation convertReservationDtoToReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();

        reservation.setReservationId(reservationDto.getReservationId())
                .setStartDate(reservationDto.getStartDate())
                .setEndDate(reservationDto.getEndDate())
                .setPrice(reservationDto.getPrice())
                .setBranch(getBranchFromReservationDto(reservationDto))
                .setCustomer(getCustomerFromReservationDto(reservationDto))
                .setCar(getCarFromReservationDto(reservationDto));

        return reservation;
    }

    private ReservationDto convertReservationToReservationDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setReservationId(reservation.getReservationId())
                .setStartDate(reservation.getStartDate())
                .setEndDate(reservation.getEndDate())
                .setPrice(reservation.getPrice())
                .setBranchId(reservation.getBranch() != null ? reservation.getBranch().getBranchId() : null)
                .setCustomerId(reservation.getCustomer() != null ? reservation.getCustomer().getCustomerId() : null)
                .setCarId(reservation.getCar().getCarId() != null ? reservation.getCar().getCarId() : null);

        return reservationDto;
    }

    private Branch getBranchFromReservationDto(ReservationDto reservationDto) {
        Branch branch = null;

        try {
            Optional<Branch> branchFromDto = branchRepository.findById(reservationDto.getBranchId());
            branch = branchFromDto.orElse(null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return branch;
    }

    private Customer getCustomerFromReservationDto(ReservationDto reservationDto) {
        Customer customer = null;

        try {
            Optional<Customer> customerFromDto = customerRepository.findById(reservationDto.getCustomerId());
            customer = customerFromDto.orElse(null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return customer;
    }

    private Car getCarFromReservationDto(ReservationDto reservationDto) {
        Car car = null;

        try {
            Optional<Car> carFromDto = carRepository.findById(reservationDto.getCarId());
            car = carFromDto.orElse(null);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return car;
    }
}
