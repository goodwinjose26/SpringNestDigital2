package com.example.nestdigitalapp2_backend.dao;

import com.example.nestdigitalapp2_backend.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
