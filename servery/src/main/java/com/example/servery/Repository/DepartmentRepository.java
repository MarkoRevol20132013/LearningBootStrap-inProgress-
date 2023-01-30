package com.example.servery.Repository;

import com.example.servery.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentNameIgnoreCase(String name);
}
