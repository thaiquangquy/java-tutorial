package org.example.hibernate.optimization.queryPerformance.repository;

import org.example.hibernate.optimization.queryPerformance.enity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findAll();

    @Override
    Optional<Department> findById(Long id);
}
