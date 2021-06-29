package com.javaRemote.project.service;

import com.javaRemote.project.database.dto.CarDto;
import com.javaRemote.project.database.entities.Branch;
import com.javaRemote.project.database.entities.Car;
import com.javaRemote.project.repository.BranchRepository;
import com.javaRemote.project.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;
    private BranchRepository branchRepository;

    public CarService(CarRepository carRepository, BranchRepository branchRepository) {
        this.carRepository = carRepository;
        this.branchRepository = branchRepository;
    }

    public Car create(CarDto carDto) {
        return carRepository.save(convertToCar(carDto));
    }

    public List<CarDto> getAllCars() {
        List<CarDto> carDtoList = new ArrayList<>();

        for (Car car : carRepository.findAll()){
            carDtoList.add(convertToCarDto(car));
        }

        return carDtoList;
    }

    public Car getCarByCarId(int carId) {
        return carRepository.getById(carId);
    }


    public Car updateCar(int carId, CarDto carDto) {
        Car carToUpdate = carRepository.getById(carId);
        Car inputCar = convertToCar(carDto);

        carToUpdate.setModel(inputCar.getModel() != null ? inputCar.getModel() : carToUpdate.getModel())
                .setTransmission(inputCar.getTransmission() != null ? inputCar.getTransmission() : carToUpdate.getTransmission())
                .setBodyType(inputCar.getBodyType() != null ? inputCar.getBodyType() : carToUpdate.getBodyType())
                .setYearCar(inputCar.getYearCar() != null ? inputCar.getYearCar() : carToUpdate.getYearCar())
                .setStatus(inputCar.getStatus() != null ? inputCar.getStatus() : carToUpdate.getStatus())
                .setPrice(inputCar.getPrice() != null ? inputCar.getPrice() : carToUpdate.getPrice());

        return carRepository.save(carToUpdate);
    }

    public void deleteCarById(int carId) {
        carRepository.deleteById(carId);
    }

    private Car convertToCar(CarDto carDto) {
        Car car = new Car();
        Optional<Branch> branchFromDto = branchRepository.findById(carDto.getBranchId());

        car.setCarId(carDto.getCarId())
                .setModel(carDto.getModel())
                .setTransmission(carDto.getTransmission())
                .setBodyType(carDto.getBodyType())
                .setYearCar(carDto.getYearCar())
                .setStatus(carDto.getStatus())
                .setPrice(carDto.getPrice())
                .setBranch(branchFromDto.orElse(null));

        return car;
    }

    private CarDto convertToCarDto(Car car) {
        CarDto carDto = new CarDto();

        carDto.setCarId(car.getCarId())
                .setModel(car.getModel())
                .setTransmission(car.getTransmission())
                .setBodyType(car.getBodyType())
                .setYearCar(car.getYearCar())
                .setStatus(car.getStatus())
                .setPrice(car.getPrice())
                .setBranchId(car.getBranch() != null ? car.getBranch().getBranchId() : 0);

        return carDto;
    }
}
