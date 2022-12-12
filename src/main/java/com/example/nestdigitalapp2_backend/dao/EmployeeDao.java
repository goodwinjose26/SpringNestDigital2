package com.example.nestdigitalapp2_backend.dao;

import com.example.nestdigitalapp2_backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `empcode`, `name`, `password`, `phno`, `username` FROM `employees` WHERE `empcode`=:empcode",nativeQuery = true)
    List<Employee> searchEmployee(@Param("empcode") String empcode);
}
