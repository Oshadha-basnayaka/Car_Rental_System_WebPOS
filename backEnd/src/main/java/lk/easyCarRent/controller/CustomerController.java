package lk.easyCarRent.controller;

import lk.easyCarRent.dto.CustomerDTO;
import lk.easyCarRent.dto.UserDTO;
import lk.easyCarRent.entity.User;
import lk.easyCarRent.service.CustomerService;
import lk.easyCarRent.service.UserService;
import lk.easyCarRent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseUtil getAllCustomer(){
        return new ResponseUtil("OK","Account Create Successfully",null);
    }




    @PostMapping
    public ResponseUtil addCustomer(@ModelAttribute CustomerDTO customerDTO , @ModelAttribute UserDTO userDTO) {

        System.out.println(customerDTO.toString());
        System.out.println(userDTO.toString());

        customerDTO.setUser(userDTO);
        customerService.saveCustomer(customerDTO);
        return new ResponseUtil("OK","Account Create Successfully",null);
    }



}
