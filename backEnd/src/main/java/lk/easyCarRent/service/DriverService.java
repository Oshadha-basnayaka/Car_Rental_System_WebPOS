package lk.easyCarRent.service;

import lk.easyCarRent.dto.CustomerDTO;
import lk.easyCarRent.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {

    ArrayList<DriverDTO> getAllDriver();
    void saveDriver(DriverDTO driverDTO);
    void updateDriver(DriverDTO driverDTO);
    void deleteDriver(DriverDTO driverDTO);
}
