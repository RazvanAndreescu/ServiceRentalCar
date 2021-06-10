package com.javaRemote.project.service;

import com.javaRemote.project.database.entities.Car;
import com.javaRemote.project.repository.CarRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public Car create(Car car){
        return carRepository.save(car);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCarByCarId(int carId){
        return carRepository.findCarByCarId(carId);
    }


    public Car updateCar(int id, Car car){
        Car carToUpdate = carRepository.getById(id);
        carToUpdate
                .setModel(car.getModel() != null ? car.getModel() : carToUpdate.getModel())
                .setTransmission(car.getTransmission() != null ? car.getTransmission() : carToUpdate.getTransmission())
                .setBodyType(car.getBodyType() != null ? car.getBodyType() : carToUpdate.getBodyType())
                .setYearCar(car.getYearCar() != null ? car.getYearCar() : carToUpdate.getYearCar())
                .setStatus(car.getStatus() != null ? car.getStatus() : carToUpdate.getStatus())
                .setPrice(car.getPrice() != 0 ? car.getPrice() : carToUpdate.getPrice());
               return carRepository.save(carToUpdate);
    }

    public void deleteCarById(int id){
        carRepository.deleteById(id);
    }
}
