package lk.easyCarRent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class LoginDetails {
    @Id
    private String loginID;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "userName", referencedColumnName = "userName", nullable = false)
    private User userName;
    private String date;
    private String time;
}
