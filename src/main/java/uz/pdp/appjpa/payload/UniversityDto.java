package uz.pdp.appjpa.payload;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniversityDto {

    private String name;
    private String city;
    private String district;
    private String street;
}
