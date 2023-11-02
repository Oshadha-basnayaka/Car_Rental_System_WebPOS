package lk.easyCarRent.service.impl;

import lk.easyCarRent.dto.CarDTO;
import lk.easyCarRent.dto.CustomerDTO;
import lk.easyCarRent.entity.Car;

import lk.easyCarRent.entity.Customer;
import lk.easyCarRent.entity.User;
import lk.easyCarRent.repo.CarRepo;

import lk.easyCarRent.service.CarService;
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
public class CarServiceImpl implements CarService {


    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> all = carRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<CarDTO>>() {
        }.getType());
    }




    @Override
    public void saveCar(CarDTO carDTO) {




        Car car = modelMapper.map(carDTO, Car.class);


        if (carRepo.existsById(carDTO.getCarID())) {
            throw new RuntimeException("Car Id Duplication");
        }




        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/upload/car/frontImage");
            File file2 = new File(path + "/upload/car/rearImage");
            File file3 = new File(path + "/upload/car/sideImage");
            File file4 = new File(path + "/upload/car/interiorImage");

            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Directory 'frontIMG' created");
            }


            if (!file2.exists()) {
                file.mkdirs();
                System.out.println("Directory 'rearImage' created");
            }

            if (!file3.exists()) {
                file.mkdirs();
                System.out.println("Directory 'sideImage' created");
            }


            if (!file4.exists()) {
                file.mkdirs();
                System.out.println("Directory 'interiorImage' created");
            }




            File frontFile = new File(file.getAbsolutePath() + "/" + carDTO.getFrontImage()
                    .getOriginalFilename());
            if (frontFile.exists()) {
                throw new RuntimeException("File 'CarFront/" + frontFile.getName() + "allrady Exists");
            } else {
                carDTO.getFrontImage().transferTo(frontFile);
                car.setFrontImage("upload/car/CarFront" + frontFile.getName());
            }



            File RearFile = new File(file2.getAbsolutePath() + "/" + carDTO.getRearImage()
                    .getOriginalFilename());
            if (RearFile.exists()) {
                throw new RuntimeException("File 'CarRear/" + RearFile.getName() + "allrady Exists");
            } else {
                carDTO.getRearImage().transferTo(RearFile);
                car.setRearImage("upload/car/CarRear" + RearFile.getName());
            }



            File SideFile = new File(file3.getAbsolutePath() + "/" + carDTO.getSideImage()
                    .getOriginalFilename());
            if (SideFile.exists()) {
                throw new RuntimeException("File 'CarRear/" + SideFile.getName() + "allrady Exists");
            } else {
                carDTO.getSideImage().transferTo(SideFile);
                car.setSideImage("upload/car/CarRear" + SideFile.getName());
            }



            File InteriorFile = new File(file3.getAbsolutePath() + "/" + carDTO.getInteriorImage()
                    .getOriginalFilename());
            if (InteriorFile.exists()) {
                throw new RuntimeException("File 'CarRear/" + InteriorFile.getName() + "allrady Exists");
            } else {
                carDTO.getInteriorImage().transferTo(InteriorFile);
                car.setInteriorImage("upload/car/CarRear" + InteriorFile.getName());
            }



            System.out.println(car);
            carRepo.save(car);
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println(e);

        }

    }

    @Override
    public void updateCar(CarDTO carDTO) {

    }

    @Override
    public void deleteCar(CarDTO carDTO) {

    }
}
