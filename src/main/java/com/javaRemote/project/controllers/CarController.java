package com.javaRemote.project.controllers;


import com.javaRemote.project.database.dto.CarDto;
import com.javaRemote.project.database.entities.Car;
import com.javaRemote.project.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public List<CarDto> printAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/")
    @ResponseBody
    public Car createCar(@RequestBody CarDto carDto) {
        return carService.create(carDto);
    }

    @PutMapping("/{carId}")
    @ResponseBody
    public boolean updateCar(@PathVariable int carId, @RequestBody CarDto carDto) {
        Car carBeforeUpdate = new Car(carService.getCarByCarId(carId));

        if (carService.getCarByCarId(carId) == null) {
            return false;
        }

        return !carService.updateCar(carId, carDto).equals(carBeforeUpdate);
    }

    @DeleteMapping("/{carId}")
    public boolean deleteCarById(@PathVariable int carId) {
        if (carService.getCarByCarId(carId) != null) {
            carService.deleteCarById(carId);
            return true;
        }

        return false;
    }
}
