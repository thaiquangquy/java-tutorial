package org.example.hibernate.optimization.queryPerformance.controller;

import lombok.AllArgsConstructor;
import org.example.hibernate.optimization.queryPerformance.enity.Department;
import org.example.hibernate.optimization.queryPerformance.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeeController {
    private final String EMPLOYEE_PATH = "employee";
    private final String DEPARTMENT_PATH = "department";

    private final DepartmentService departmentService;

    @GetMapping(path = DEPARTMENT_PATH)
    public ResponseEntity<?> getAllDepartment() {
        return new ResponseEntity<>(departmentService.getListDepartment(), HttpStatus.OK);
    }
}
