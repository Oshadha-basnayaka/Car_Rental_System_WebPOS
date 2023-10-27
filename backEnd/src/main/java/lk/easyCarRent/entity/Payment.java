package lk.easyCarRent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString


public class Payment {
    @Id
    private String paymentID;
    private Double waiverDeductions;
    private String waiverSlip;
    private Double extraMileagePayment;
}
