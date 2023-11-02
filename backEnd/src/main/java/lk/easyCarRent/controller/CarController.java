package lk.easyCarRent.controller;

import lk.easyCarRent.dto.CarDTO;
import lk.easyCarRent.dto.CustomerDTO;
import lk.easyCarRent.dto.UserDTO;
import lk.easyCarRent.service.CarService;
import lk.easyCarRent.service.CustomerService;
import lk.easyCarRent.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {


    @Autowired
    CarService carService;

    @GetMapping
    public ResponseUtil getAllCars(){
        return new ResponseUtil("OK"," Successfully load",carService.getAllCars());
    }




    @PostMapping
    public ResponseUtil addCars(@ModelAttribute CarDTO carDTO ) {

        System.out.println(carDTO.toString());



        carService.saveCar(carDTO);
        return new ResponseUtil("OK","Account Create Successfully",null);
    }


}
