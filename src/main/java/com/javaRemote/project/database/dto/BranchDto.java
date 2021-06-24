package com.javaRemote.project.database.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BranchDto {

    private int branchId;
    private String address;
    private int rentalId;

    private List<CarDto> carsDto;
    private List<EmployeeDto> employeesDto;
    private List<ReservationDto> reservationsDto;

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

    public BranchDto setCarsDto(List<CarDto> carsDto) {
        this.carsDto = carsDto;
        return this;
    }

    public BranchDto setEmployeesDto(List<EmployeeDto> employeesDto) {
        this.employeesDto = employeesDto;
        return this;
    }

    public BranchDto setReservationsDto(List<ReservationDto> reservationsDto) {
        this.reservationsDto = reservationsDto;
        return this;
    }
}
