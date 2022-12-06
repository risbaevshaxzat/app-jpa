package uz.pdp.appjpa.servis;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.appjpa.entity.Subject;
import uz.pdp.appjpa.entity.University;
import uz.pdp.appjpa.repository.SubjectRepositry;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjkectService {

    private final SubjectRepositry subjectRepositry;


    public List<Subject> GetAll( ){
        return subjectRepositry.findAll();
    }

   public Subject addSubJect(Subject subject){
       return subjectRepositry.save(subject);
   }

    public University deletAL(Integer id){
         subjectRepositry.deleteById(id);
         return null;
    }
}

