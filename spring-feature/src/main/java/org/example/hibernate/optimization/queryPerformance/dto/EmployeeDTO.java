package org.example.hibernate.optimization.queryPerformance.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployeeDTO {
    Long id;
    String name;
    DepartmentDTO department;
}
