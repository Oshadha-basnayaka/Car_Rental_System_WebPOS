package lk.easyCarRent.repo;

import lk.easyCarRent.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,String> {
}
