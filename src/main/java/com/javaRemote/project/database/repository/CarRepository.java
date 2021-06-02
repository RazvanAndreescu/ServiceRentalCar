package com.javaRemote.project.database.repository;

import com.javaRemote.project.database.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> getCarByModel(String model);
    List<Car> getCarByTransmission(String transmission);
    List<Car> getCarByBodyType(String bodyType);
    List<Car> getCarByYearCar(String yearCar);
    List<Car> getCarByStatus(String status);
    List<Car> getCarByPrice(int price);
}
