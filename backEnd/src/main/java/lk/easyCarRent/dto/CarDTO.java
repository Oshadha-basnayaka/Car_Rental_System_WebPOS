package lk.easyCarRent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {

    private String carID;
    private String regNO;
    private String brand;
    private String type;
    private String passenger;
    private String color;
    private String transmissionType;
    private String fuelType;
    private String extraMileagePrice;
    private String currentMileage;

    private String wavierPayment;
    private String availability;

    private String freeMileageDaily;
    private String freeMileageDailyPrice;

    private String freeMileageMonthly;
    private String freeMileageMonthlyPrice;


    private MultipartFile frontImage;
    private MultipartFile rearImage;
    private MultipartFile sideImage;
    private MultipartFile interiorImage;



}
