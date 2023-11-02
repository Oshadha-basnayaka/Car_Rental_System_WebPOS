package lk.easyCarRent.service.impl;

import lk.easyCarRent.dto.DriverDTO;
import lk.easyCarRent.entity.Driver;
import lk.easyCarRent.entity.User;
import lk.easyCarRent.repo.DriverRepo;
import lk.easyCarRent.service.DriverService;
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
public class DriverServiceImpl implements DriverService {


    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;




    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        List<Driver> all = driverRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<DriverDTO>>() {
        }.getType());

    }






    @Override
    public void saveDriver(DriverDTO driverDTO) {


        Driver driver = modelMapper.map(driverDTO,Driver.class);
        driver.setUser(new User(driver.getUser().getUserName(),driver.getUser().getPassword(), "Driver"));


        if (driverRepo.existsById(driverDTO.getDriverID())) {
            throw new RuntimeException("Customer Id Duplication");
        } else if (driverRepo.existsById(driverDTO.getUser().getUserName())) {
            throw new RuntimeException("This User Name already taken");
        }




        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/upload/driver/frontImage");
            File file2 = new File(path + "/upload/driver/backImage");

            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Directory 'frontIMG' created");
            }


            if (!file2.exists()) {
                file.mkdirs();
                System.out.println("Directory 'BackIMG' created");
            }


            File frontFile = new File(file.getAbsolutePath() + "/" + driverDTO.getFrontImage()
                    .getOriginalFilename());
            if (frontFile.exists()) {
                throw new RuntimeException("File 'licenseFront/" + frontFile.getName() + "allrady Exists");
            } else {
                driverDTO.getFrontImage().transferTo(frontFile);
                driver.setFrontImage("upload/driver/licenseFront" + frontFile.getName());
            }


            File backFile = new File(file2.getAbsolutePath() + "/" + driverDTO.getBackImage()
                    .getOriginalFilename());
            if (backFile.exists()) {
                throw new RuntimeException("File 'licenseBack/" + backFile.getName() + "allrady Exists");
            } else {
                driverDTO.getBackImage().transferTo(backFile);
                driver.setBackImage("upload/driver/licenseBack" + backFile.getName());
            }


            System.out.println(driver);
            driverRepo.save(driver);
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println(e);

        }





    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {

    }

    @Override
    public void deleteDriver(DriverDTO driverDTO) {

    }
}
