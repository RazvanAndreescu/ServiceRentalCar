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


    //Create
    public Car create(Car car){
        return carRepository.save(car);
    }

    public List<?> getAllCars(){
        return carRepository.findAll();
    }

    public List<?> getCarsByModel(String model){
        return carRepository.getCarByModel(model);
    }

    public List<?> getCarsByTransmission(String transmission){
        return carRepository.getCarByTransmission(transmission);
    }

    public List<?> getCarByBodyType(String bodyType){
        return carRepository.getCarByBodyType(bodyType);
    }

    public List<?> getCarByYearCar(String yearCar){
        return carRepository.getCarByYearCar(yearCar);
    }

    public List<?> getCarByStatus(String status){
        return carRepository.getCarByStatus(status);
    }

    public List<?> getCarByPrice(int price){
        return carRepository.getCarByPrice(price);
    }


    //Update
    public Car updateModel(int id, String model){
        Car car = carRepository.getById(id);
        car.setModel(model);
        return car;
    }

    public Car updateTransmission(int id, String transmission){
        Car car = carRepository.getById(id);
        car.setTransmission(transmission);
        return car;
    }

    public Car updateBodyType(int id, String bodyType){
        Car car = carRepository.getById(id);
        car.setBodyType(bodyType);
        return car;
    }

    public Car updateYearCar(int id, String yearCar){
        Car car = carRepository.getById(id);
        car.setYearCar(yearCar);
        return car;
    }

    public Car updateStatus(int id, String status){
        Car car = carRepository.getById(id);
        car.setStatus(status);
        return car;
    }

    public Car updatePrice(int id, int price){
        Car car = carRepository.getById(id);
        car.setPrice(price);
        return car;
    }

    //Delete
    public void deleteCar(Car car){
        carRepository.delete(car);
    }

    public void deleteCarById(int id){
        carRepository.deleteById(id);
    }

}
