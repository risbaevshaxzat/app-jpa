package uz.pdp.appjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appjpa.entity.University;
@Repository
public interface UniversityRepositpory extends JpaRepository<University , Integer> {
}
