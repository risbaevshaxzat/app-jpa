package uz.pdp.appjpa.servis;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appjpa.entity.University;
import uz.pdp.appjpa.repository.UniversityRepositpory;

@Service
@AllArgsConstructor
public class UniversityService {

    private final UniversityRepositpory universityRepositpory;



    public University deletAL(Integer id){
         universityRepositpory.deleteById(id);
         return null;
    }
}

