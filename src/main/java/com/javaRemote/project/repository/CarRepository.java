package com.javaRemote.project.repository;

import com.javaRemote.project.database.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findCarByCarId(int carId);

    List<Car> findCarsByBranch_BranchId(int BranchId);
}
