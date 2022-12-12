package com.example.nestdigitalapp2_backend.dao;

import com.example.nestdigitalapp2_backend.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {

    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `empcode`, `name`, `password`, `phno`, `username` FROM `employees` WHERE `empcode`=:empcode",nativeQuery = true)
    List<Employee> searchEmployee(@Param("empcode") String empcode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employees` WHERE `id`=:id",nativeQuery = true)
    void deleteemp(@Param("id") Integer id);

    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `empcode`, `name`, `password`, `phno`, `username` FROM `employees` WHERE  `username`=:username AND`password`=:password ",nativeQuery = true)
    List<Employee> emplogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT `id`, `address`, `designation`, `email`, `empcode`, `name`, `password`, `phno`, `username` FROM `employees` WHERE `empcode`=:empcode",nativeQuery = true)
    List<Employee> profileview(@Param("empcode") String empcode);

}
