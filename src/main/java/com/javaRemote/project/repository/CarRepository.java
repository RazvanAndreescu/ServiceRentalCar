package com.javaRemote.project.repository;

import com.javaRemote.project.database.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findCarByCarId(int carId);
}
