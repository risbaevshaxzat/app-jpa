package uz.pdp.appjpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="grpups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Faculty faculty;

    @OneToMany
    private List<Student> students;
}
