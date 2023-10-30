package lk.easyCarRent.repo;

import lk.easyCarRent.entity.Car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String> {
}
