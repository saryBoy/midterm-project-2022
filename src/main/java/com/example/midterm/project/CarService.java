package com.example.midterm.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car addNewCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCarById(Long carId) {
        return carRepository.getById(carId);
    }

    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }
}
