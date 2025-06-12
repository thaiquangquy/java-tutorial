package org.example.hibernate.optimization.queryPerformance.enity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "department")
    private List<Employee> employees;
}
