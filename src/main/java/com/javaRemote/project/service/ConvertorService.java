package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.*;
import com.javaRemote.project.database.entities.*;
import com.javaRemote.project.repository.*;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConvertorService {

    private final BranchRepository branchRepository;
    private final RentalRepository rentalRepository;
    private final EmployeeRepository employeeRepository;
    private final CarRepository carRepository;
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    public ConvertorService(BranchRepository branchRepository,
                            RentalRepository rentalRepository,
                            EmployeeRepository employeeRepository,
                            CarRepository carRepository,
                            ReservationRepository reservationRepository,
                            CustomerRepository customerRepository) {
        this.branchRepository = branchRepository;
        this.rentalRepository = rentalRepository;
        this.employeeRepository = employeeRepository;
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
    }

    public Branch convertToBranchEntity(@NotNull BranchDto branchDto){
        Branch branch = new Branch();
        return branch
                .setBranchId(branchDto.getBranchId())
                .setAddress(branchDto.getAddress())
                // gaseste rentalul dupa id-ul rentaluluiDto din BranchDto
                .setRental(rentalRepository.getById(branchDto.getBranchId()));

    }

    public BranchDto convertToBranchDto(Branch branch){
        BranchDto branchDto = new BranchDto();
        return branchDto
                .setBranchId(branch.getBranchId())
                .setAddress(branch.getAddress())
                .setRentalId(branch.getRental().getRentalId());
    }

    public Customer convertToCustomerEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        return customer
                .setCustomerId(customerDto.getCustomerId())
                .setNameCustomer(customerDto.getNameCustomer())
                .setEmail(customerDto.getEmail())
                .setDrivingExperience(customer.getDrivingExperience())
                .setReservations(reservationRepository.findReservationsByCustomer_CustomerId(customerDto.getCustomerId()));
    }

    public CustomerDto convertToCustomerDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for(Reservation reservation: customer.getReservations()){
            reservationDtoList.add(convertToReservationDto(reservation));
        }
        return customerDto
                .setCustomerId(customer.getCustomerId())
                .setNameCustomer(customer.getNameCustomer())
                .setEmail(customer.getEmail())
                .setDrivingExperience(customer.getDrivingExperience())
                .setReservationDtoList(reservationDtoList);
    }

    public Employee convertToEmployeeEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        return employee
                .setEmployeeId(employeeDto.getEmployeeId())
                .setNameEmployee(employeeDto.getNameEmployee())
                .setRoleEmployee(employee.getRoleEmployee())
                .setBranch(branchRepository.getById(employeeDto.getBranchId()));
    }

    public EmployeeDto convertToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        return employeeDto
                .setEmployeeId(employee.getEmployeeId())
                .setNameEmployee(employee.getNameEmployee())
                .setRoleEmployee(employee.getRoleEmployee())
                .setBranchId(employee.getBranch().getBranchId());
    }

    public Rental convertToRentalEntity(RentalDto rentalDto){
        Rental rental = new Rental();
        rental
                .setRentalId(rentalDto.getRentalId())
                .setNameRental(rentalDto.getNameRental())
                .setInternetDomain(rentalDto.getInternetDomain())
                .setContactAddress(rentalDto.getContactAddress())
                .setOwner(rentalDto.getOwner())
                .setBranches(branchRepository.getBranchesByRental_RentalId(rental.getRentalId()));
        return rental;
    }

    public RentalDto convertToRentalDTO(Rental rental){
        RentalDto rentalDTO = new RentalDto();
        List<BranchDto> branchDtoList = new ArrayList<>();
        for (Branch localBranch: rental.getBranches()){
            branchDtoList.add(convertToBranchDto(localBranch));
        }
        rentalDTO.setRentalId(rental.getRentalId())
                .setNameRental(rental.getNameRental())
                .setInternetDomain(rental.getInternetDomain())
                .setContactAddress(rental.getContactAddress())
                .setOwner(rental.getOwner())
                .setBranches(branchDtoList);
        return rentalDTO;
    }

    public Reservation convertToReservation(ReservationDto reservationDto){
        Reservation reservation = new Reservation();
        reservation
                .setReservationId(reservationDto.getReservationId())
                .setStartDate(reservationDto.getStartDate())
                .setEndDate(reservationDto.getEndDate())
                .setPrice(reservationDto.getPrice())
                .setBranch(branchRepository.getById(reservationDto.getBranchId()))
                .setCustomer(customerRepository.getById(reservationDto.getCustomerId()))
                .setCar(carRepository.getById(reservationDto.getCarId()));

        return reservation;
    }

    public ReservationDto convertToReservationDto(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto
                .setReservationId(reservation.getReservationId())
                .setStartDate(reservation.getStartDate())
                .setEndDate(reservation.getEndDate())
                .setPrice(reservation.getPrice())
                .setBranchId(reservation.getBranch().getBranchId())
                .setCustomerId(reservation.getCustomer().getCustomerId())
                .setCarId(reservation.getCar().getCarId());
        return reservationDto;
    }
}
