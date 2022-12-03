package uz.pdp.appjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appjpa.entity.Address;
import uz.pdp.appjpa.entity.University;
import uz.pdp.appjpa.payload.UniversityDto;
import uz.pdp.appjpa.repository.AddressRepositry;
import uz.pdp.appjpa.repository.UniversityRepositpory;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class UniversittyController {

    @Autowired
    UniversityRepositpory universityRepositpory;

    @Autowired
    AddressRepositry addressRepositry;

    @GetMapping("/university")
    public List<University> getUniversity(){
        List<University> universityList = universityRepositpory.findAll();
        return universityList;
    }

    @PostMapping("/university")
    public String addUniversity(@RequestBody UniversityDto universityDto){
        Address address = new Address();
        address.setCity(universityDto.getCity());
        address.setDistrict(universityDto.getDistrict());
        address.setStreet(universityDto.getStreet());

        Address addressSave = addressRepositry.save(address);

        University university = new University();
        university.setName(universityDto.getName());
        university.setAddress(addressSave);
        universityRepositpory.save(university);

         return "University added";

    }
    @PutMapping("/university/{id}")
    public String editUniversity(@PathVariable Integer id ,@RequestBody UniversityDto universityDto){
       Optional<University> optionalUniversity= universityRepositpory.findById(id);
       if(optionalUniversity.isPresent()){
           University university = optionalUniversity.get();
           university.setName(universityDto.getName());

           Address address = university.getAddress();
           address.setCity(universityDto.getCity());
           address.setDistrict(universityDto.getDistrict());
           address.setStreet(universityDto.getStreet());
           addressRepositry.save(address);

           universityRepositpory.save(university);
           return "Edited University ";
       }
       return "not fount";

    }

    @DeleteMapping("/university/{id}")
    public ResponseEntity<?> deleteUniversity(@PathVariable Integer id){
        universityRepositpory.deleteById(id);
        return ResponseEntity.ok("\"Delete University\";");
    }
}
