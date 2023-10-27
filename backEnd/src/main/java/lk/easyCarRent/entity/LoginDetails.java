package lk.easyCarRent.entity;

import javax.persistence.Id;

public class LoginDetails {
    @Id
    private String loginID;


    private User userName;
}
