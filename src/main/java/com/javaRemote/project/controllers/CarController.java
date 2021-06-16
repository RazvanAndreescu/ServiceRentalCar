package com.javaRemote.project.controllers;

import com.javaRemote.project.database.entities.Car;
import com.javaRemote.project.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/")
    public List<Car> printAllCars(){
        return carService.getAllCars();
    }

    @PostMapping("/")
    @ResponseBody
    public Car createCar(@RequestBody Car car){
        carService.create(car);
        return car;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public boolean updateCar(@PathVariable int id, @RequestBody Car car){
        if(carService.getCarByCarId(id) != null){
            carService.updateCar(id,car);
            return true;
        }
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean deleteCarById(@PathVariable int id){
        if(carService.getCarByCarId(id) != null){
            carService.deleteCarById(id);
            return true;
        }
        return false;
    }
}
