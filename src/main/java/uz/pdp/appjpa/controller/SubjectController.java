package uz.pdp.appjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appjpa.entity.Address;
import uz.pdp.appjpa.entity.Subject;
import uz.pdp.appjpa.entity.University;
import uz.pdp.appjpa.payload.UniversityDto;
import uz.pdp.appjpa.repository.SubjectRepositry;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class SubjectController {

    @Autowired
    SubjectRepositry subjectRepositry;

    @PostMapping("/subject")
    public String AddSubject(@RequestBody Subject subject){
        subjectRepositry.save(subject);
        boolean existByNmae = subjectRepositry.existsByName(subject.getName());
        if(existByNmae){
            return "Add Subject";
        }
        return "This  subject already exis";
    }

    @GetMapping("subject")
    public List<Subject> showAll(){
       List<Subject>  subjectList = subjectRepositry.findAll();

        return  subjectList;
    }
    @PutMapping("/subject/{id}")
    public ResponseEntity<?> editSubject(@PathVariable Integer id ,@RequestBody Subject subject){
        Optional<Subject> optionalSubject= subjectRepositry.findById(id);
            return ResponseEntity.ok("Edited Subject ");

    }
    @DeleteMapping("/subject/{id}")
    public ResponseEntity<?>  deleteAll(@PathVariable Integer id){
         subjectRepositry.deleteById(id);
         return ResponseEntity.ok("Delete Subject");
    }


}
