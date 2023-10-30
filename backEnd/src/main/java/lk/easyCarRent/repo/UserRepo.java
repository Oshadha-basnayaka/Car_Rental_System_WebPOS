package lk.easyCarRent.repo;

import lk.easyCarRent.entity.Customer;
import lk.easyCarRent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
