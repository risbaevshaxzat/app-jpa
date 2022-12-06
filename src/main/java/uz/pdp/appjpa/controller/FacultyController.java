package uz.pdp.appjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appjpa.entity.Faculty;
import uz.pdp.appjpa.entity.University;
import uz.pdp.appjpa.payload.FacultyDto;
import uz.pdp.appjpa.repository.FacultyRepositry;
import uz.pdp.appjpa.repository.UniversityRepositpory;

import java.util.Optional;

@RestController
@Controller
@RequestMapping("/")
public class FacultyController {

    @Autowired
    FacultyRepositry facultyRepositry;
    @Autowired
    UniversityRepositpory universityRepositpory;

    @PostMapping("/faculty")
    public String  addFaculty(@RequestBody FacultyDto facultyDto){
        Faculty  faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        Optional<University> optionalUniversity =universityRepositpory.findById(facultyDto.getUniversityid());
        faculty.setUniversity(optionalUniversity.get());

        facultyRepositry.save(faculty);
        return "Faculty saved";
    }
}
