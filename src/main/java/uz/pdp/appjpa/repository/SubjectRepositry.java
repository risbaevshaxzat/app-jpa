package uz.pdp.appjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appjpa.entity.Address;
import uz.pdp.appjpa.entity.Subject;

public interface SubjectRepositry extends JpaRepository<Subject,Integer> {

    boolean existsByName(String  name);
}
