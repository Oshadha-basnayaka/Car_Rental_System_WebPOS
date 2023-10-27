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

public class Customer {

    @Id
    private String customerID;
    private String name;
    private String address;
    private String email;
    private String contactNO;
    private String licenceNO;
    private String frontImage;
    private String backImage;

@OneToOne(cascade = CascadeType.ALL)
    private User user;
}
