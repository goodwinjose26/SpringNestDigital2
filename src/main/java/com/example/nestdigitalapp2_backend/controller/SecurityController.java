package com.example.nestdigitalapp2_backend.controller;

import com.example.nestdigitalapp2_backend.dao.SecurityDao;
import com.example.nestdigitalapp2_backend.model.Employee;
import com.example.nestdigitalapp2_backend.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class SecurityController {

    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public Map<String,String> reg(@RequestBody Security s)
    {
        dao.save(s);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsec")
    public List<Security> view()
    {
        return (List<Security>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/seclogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> seclogin(@RequestBody Security s)
    {
        String username=String.valueOf(s.getUsername());
        String password=String.valueOf(s.getPassword());
        List<Security> result=(List<Security>) dao.seclogin(username,password);
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0)
        {
            st.put("status","failed");
        }
        else
        {
            String id=result.get(0).getSeccode();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
        }
        return st;

    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/secprofileview",consumes = "application/json",produces = "application/json")
    public List<Security> secprofileview(@RequestBody Security s)
    {
        String seccode=String.valueOf(s.getSeccode());
        System.out.println(seccode);
        return (List<Security>) dao.secprofileview(s.getSeccode());

    }
}
