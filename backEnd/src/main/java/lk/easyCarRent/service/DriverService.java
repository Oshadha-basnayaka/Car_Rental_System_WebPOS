package lk.easyCarRent.service;

import lk.easyCarRent.dto.CustomerDTO;
import lk.easyCarRent.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {

    ArrayList<DriverDTO> getAllCustomer();
    void saveCustomer(DriverDTO driverDTO);
    void updateCustomer(DriverDTO driverDTO);
    void deleteCustomer(DriverDTO driverDTO);
}
