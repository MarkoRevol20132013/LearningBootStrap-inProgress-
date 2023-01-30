package com.example.servery.Service;

import com.example.servery.Repository.DepartmentRepository;
import com.example.servery.entity.Department;
import com.example.servery.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DepartmentService {

    @Autowired
   private DepartmentRepository departmentRepository;
    public String saveDepartment(Department department) {
        departmentRepository.save(department);
        return "Department saved with id: " + department.getDepartmentId()
                +"name: \n" + department.getDepartmentName() +
                "address: \n" + department.getDepartmentAddress() +
                "with code: \n" + department.getDepartmentCode();
    }

    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    public List<Department> getDepartmentbyID(Long id) throws DepartmentNotFoundException {
        Optional<Department>  department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return Collections.singletonList(department.get());
        } else throw new DepartmentNotFoundException("Department not found with id: " + id);

    }

    public String deleteDepartmentbyID(Long id) throws DepartmentNotFoundException{
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()){
                departmentRepository.deleteById(id);
        return "Department deleted with id: " + id;}
        else throw new DepartmentNotFoundException("Department not found with id: " + id);
    }

    public Department updateDepartment(Long id, Department department) {
        Department department1 = departmentRepository.findById(id).orElse(null);

        if (Objects.nonNull(department1.getDepartmentName()) &&
                department1.getDepartmentName()!= "")
        {department1.setDepartmentName(department.getDepartmentName());}

        if(Objects.nonNull(department1.getDepartmentAddress())&&
                department1.getDepartmentAddress()!= "")
        {department1.setDepartmentAddress(department.getDepartmentAddress());}

        if (Objects.nonNull(department1.getDepartmentCode())&&
                department1.getDepartmentCode()!= "")
        {department1.setDepartmentCode(department.getDepartmentCode());}
        return departmentRepository.save(department1);
    }

    public Department getDepartmentbyname(String name) {
        Department department1 = departmentRepository.findByDepartmentNameIgnoreCase(name);

        if (departmentRepository.findByDepartmentNameIgnoreCase(name) == null) {
            return null;
        } else {
            return department1;
        }
    }

}
