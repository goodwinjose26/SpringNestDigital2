package com.example.nestdigitalapp2_backend.dao;

import com.example.nestdigitalapp2_backend.model.Security;
import org.springframework.data.repository.CrudRepository;

public interface SecurityDao extends CrudRepository<Security,Integer> {
}
