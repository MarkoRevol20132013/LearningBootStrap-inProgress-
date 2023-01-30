package com.example.servery.Controller;
import java.util.List;
import com.example.servery.Service.DepartmentService;

import com.example.servery.entity.Department;
import com.example.servery.error.DepartmentNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/department")
    public String saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/department")
    public List<Department> getDepartment(){
        logger.info("Inside getDepartment of DepartmentController");
        return departmentService.getDepartment();

    }
    @GetMapping("/department/{id}")
    public List<Department> getDepartmentbyID(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        logger.info("Inside getDepartmentbyID of DepartmentController");
        return departmentService.getDepartmentbyID(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentbyID(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        logger.info("Inside deleteDepartmentbyID of DepartmentController");
        return departmentService.deleteDepartmentbyID(id);
    }
    @PutMapping ("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department){
        logger.info("Inside update Department of DepartmentController");
        return departmentService.updateDepartment(id,department);}

        @GetMapping("/department/{name}")
        public Department getDepartmentbyname(@PathVariable("name") String name){
            logger.info("Inside getDepartmentbyname of DepartmentController");
            return departmentService.getDepartmentbyname(name);
        }

}