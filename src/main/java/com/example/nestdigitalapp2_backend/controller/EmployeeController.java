package com.example.nestdigitalapp2_backend.controller;

import com.example.nestdigitalapp2_backend.dao.EmployeeDao;
import com.example.nestdigitalapp2_backend.dao.LeavecountDao;
import com.example.nestdigitalapp2_backend.model.Employee;
import com.example.nestdigitalapp2_backend.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeDao dao;


 @Autowired
 private LeavecountDao ldao;



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public Map<String,String> reg(@RequestBody Employee e)
    {
        dao.save(e);
        LeaveCount model=new LeaveCount();
        model.setEmpid(e.getEmpcode());
        model.setName(e.getName());
        model.setSickleave(7);
        model.setCasualleave(20);
        model.setSplleave(3);
        ldao.save(model);

        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewemp")
    public List<Employee> view()
    {
        return (List<Employee>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemp",consumes = "application/json",produces = "application/json")
    public List<Employee> searchStudent(@RequestBody Employee e)
    {
        String empcode=String.valueOf(e.getEmpcode());
        System.out.println(empcode);
        return (List<Employee>) dao.searchEmployee(e.getEmpcode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteemp",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> deleteemp(@RequestBody Employee e)
    {
        String id=String.valueOf(e.getId());
        System.out.println(id);
        dao.deleteemp(e.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }



}
