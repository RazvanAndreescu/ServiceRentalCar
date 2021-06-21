package com.javaRemote.project.database.dto;

import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Car;
import com.javaRemote.project.database.entities.Employee;
import com.javaRemote.project.database.entities.Reservation;
import com.javaRemote.project.repository.RentalRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BranchDto {

    RentalRepository rentalRepository;

    private int branchId;
    private String address;
    private int rentalId;

    private List<Car> cars;
    private List<Employee> employees;
    private List<Reservation> reservations;

    public BranchDto setBranchId(int branchId) {
        this.branchId = branchId;
        return this;
    }

    public BranchDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public BranchDto setRentalId(int rentalId) {
        this.rentalId = rentalId;
        return this;
    }

    public BranchDto setCars(List<Car> cars) {
        this.cars = cars;
        return this;
    }

    public BranchDto setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public BranchDto setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
        return this;
    }

    public Branch convertToBranchEntity(@NotNull BranchDto branchDto){
        Branch branch = new Branch();
        return branch
                .setBranchId(branchDto.getBranchId())
                .setAddress(branchDto.getAddress())
                // gaseste rentalul dupa id-ul rentaluluiDto din BranchDto
                .setRental(rentalRepository.getById(branchDto.getBranchId()));

    }


}
