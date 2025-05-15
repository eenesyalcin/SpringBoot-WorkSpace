package com.enesyalcin.controller.impl;

import com.enesyalcin.DTOs.DTOEmployee;
import com.enesyalcin.controller.IEmployeeController;
import com.enesyalcin.services.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api/employee")
public class EmployeeController implements IEmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @Override
    @GetMapping(path = "/list")
    public List<DTOEmployee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
