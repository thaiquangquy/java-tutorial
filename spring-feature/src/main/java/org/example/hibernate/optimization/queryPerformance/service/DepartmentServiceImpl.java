package org.example.hibernate.optimization.queryPerformance.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.hibernate.optimization.queryPerformance.dto.DepartmentDTO;
import org.example.hibernate.optimization.queryPerformance.enity.Department;
import org.example.hibernate.optimization.queryPerformance.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getListDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
