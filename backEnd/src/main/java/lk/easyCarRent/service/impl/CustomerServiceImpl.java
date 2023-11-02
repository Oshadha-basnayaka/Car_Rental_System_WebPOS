package lk.easyCarRent.service.impl;

import lk.easyCarRent.dto.CustomerDTO;
import lk.easyCarRent.dto.DriverDTO;
import lk.easyCarRent.entity.Customer;
import lk.easyCarRent.entity.Driver;
import lk.easyCarRent.entity.User;
import lk.easyCarRent.repo.CustomerRepo;
import lk.easyCarRent.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }


    @Override
    public void saveCustomer(CustomerDTO customerDTO) {


        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setUser(new User(customer.getUser().getUserName(),customer.getUser().getPassword(), "Customer"));

        if (customerRepo.existsById(customerDTO.getCustomerID())) {
            throw new RuntimeException("Customer Id Duplication");
        } else if (customerRepo.existsById(customerDTO.getUser().getUserName())) {
            throw new RuntimeException("This User Name already taken");
        }




        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/upload/customer/frontImage");
            File file2 = new File(path + "/upload/customer/backImage");

            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Directory 'frontIMG' created");
            }


            if (!file2.exists()) {
                file.mkdirs();
                System.out.println("Directory 'BackIMG' created");
            }


            File frontFile = new File(file.getAbsolutePath() + "/" + customerDTO.getFrontImage()
            .getOriginalFilename());
            if (frontFile.exists()) {
                throw new RuntimeException("File 'licenseFront/" + frontFile.getName() + "allrady Exists");
            } else {
                customerDTO.getFrontImage().transferTo(frontFile);
                customer.setFrontImage("upload/customer/licenseFront" + frontFile.getName());
            }


            File backFile = new File(file2.getAbsolutePath() + "/" + customerDTO.getBackImage()
            .getOriginalFilename());
            if (backFile.exists()) {
                throw new RuntimeException("File 'licenseBack/" + backFile.getName() + "allrady Exists");
            } else {
                customerDTO.getBackImage().transferTo(backFile);
                customer.setBackImage("upload/customer/licenseBack" + backFile.getName());
            }


            System.out.println(customer);
            customerRepo.save(customer);
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println(e);

        }

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(CustomerDTO customerID) {

    }


}
