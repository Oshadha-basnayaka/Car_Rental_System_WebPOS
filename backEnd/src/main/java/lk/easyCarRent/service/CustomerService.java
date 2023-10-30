package lk.easyCarRent.service;

import lk.easyCarRent.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(CustomerDTO customerID);
   ArrayList<CustomerDTO> getAllCustomer();

}
