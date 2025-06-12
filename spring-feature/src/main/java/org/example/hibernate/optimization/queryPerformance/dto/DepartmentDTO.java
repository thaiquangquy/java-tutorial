package org.example.hibernate.optimization.queryPerformance.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDTO {
    Long id;
    String name;
    List<EmployeeDTO> employees;
}
