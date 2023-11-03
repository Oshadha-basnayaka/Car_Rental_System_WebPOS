package lk.easyCarRent.service;

import lk.easyCarRent.dto.CarDTO;
import lk.easyCarRent.dto.DriverDTO;


import java.util.ArrayList;

public interface CarService {


    ArrayList<CarDTO> getAllCars();
    void saveCar(CarDTO carDTO);
    void updateCar(CarDTO carDTO);
    void deleteCar(String carID , CarDTO carDTO);
}
