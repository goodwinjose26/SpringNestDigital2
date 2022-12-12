package com.example.nestdigitalapp2_backend.dao;

import com.example.nestdigitalapp2_backend.model.LeaveCount;
import org.springframework.data.repository.CrudRepository;

public interface LeavecountDao extends CrudRepository<LeaveCount,Integer> {
}
