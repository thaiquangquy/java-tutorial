package org.example.hibernate.optimization.queryPerformance.service;

import org.example.hibernate.optimization.queryPerformance.dto.DepartmentDTO;
import org.example.hibernate.optimization.queryPerformance.enity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getListDepartment();
    Department getDepartment(Long id);
}
