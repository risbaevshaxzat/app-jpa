package uz.pdp.appjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appjpa.entity.Address;

public interface AddressRepositry extends JpaRepository<Address,Integer> {
}
