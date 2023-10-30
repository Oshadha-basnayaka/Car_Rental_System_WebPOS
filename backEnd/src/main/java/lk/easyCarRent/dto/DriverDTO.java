package lk.easyCarRent.dto;

import lk.easyCarRent.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {


    private String driverID;
    private String drivingLicenceNo;
    private String driverName;
    private String email;
    private String contactNo;
    private MultipartFile frontImage;
    private MultipartFile backImage;
    private UserDTO user;

}
