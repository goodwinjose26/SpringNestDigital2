package com.example.nestdigitalapp2_backend.dao;

import com.example.nestdigitalapp2_backend.model.Employee;
import com.example.nestdigitalapp2_backend.model.Security;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phno`, `seccode`, `username` FROM `security` WHERE  `username`=:username AND`password`=:password ",nativeQuery = true)
    List<Security> seclogin(@Param("username") String username, @Param("password") String password);
}
