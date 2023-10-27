package lk.easyCarRent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {

    @Id
    private String driverID;
    private String drivingLicenceNo;
    private String driverName;
    private String email;
    private String contactNo;
    private String frontImage;
    private String backImage;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
