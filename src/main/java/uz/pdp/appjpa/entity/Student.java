package uz.pdp.appjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id;

    @Column(nullable = false)
    private String  firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToOne
    private Address address;

    @ManyToMany
    private List<Subject> subject;

}
