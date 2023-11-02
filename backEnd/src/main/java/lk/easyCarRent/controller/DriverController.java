package lk.easyCarRent.controller;


import lk.easyCarRent.dto.DriverDTO;
import lk.easyCarRent.dto.UserDTO;
import lk.easyCarRent.service.DriverService;
import lk.easyCarRent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverservice;


    @GetMapping
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK"," Successfully load",driverservice.getAllDriver());
    }

    @PostMapping
    public ResponseUtil addDriver(@ModelAttribute DriverDTO driverDTO , @ModelAttribute UserDTO userDTO) {

        System.out.println(driverDTO.toString());
        System.out.println(userDTO.toString());

        driverDTO.setUser(userDTO);
        driverservice.saveDriver(driverDTO);
        return new ResponseUtil("OK","Account Create Successfully",null);
    }
}
