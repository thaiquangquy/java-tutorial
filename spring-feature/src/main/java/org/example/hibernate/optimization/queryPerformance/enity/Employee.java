package org.example.hibernate.optimization.queryPerformance.enity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    Long id;
    @Column(name = "name")
    String name;
    @ManyToOne
    Department department;
}
