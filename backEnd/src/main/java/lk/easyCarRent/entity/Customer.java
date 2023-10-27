package lk.easyCarRent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
