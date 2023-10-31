package lk.easyCarRent.service;

import lk.easyCarRent.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {

    ArrayList<CustomerDTO> getAllCustomer();
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(CustomerDTO customerID);


}
