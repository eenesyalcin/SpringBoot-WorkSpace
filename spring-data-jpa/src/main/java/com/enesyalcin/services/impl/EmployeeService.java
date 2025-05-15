package com.enesyalcin.services.impl;

import com.enesyalcin.DTOs.DTODepartment;
import com.enesyalcin.DTOs.DTOEmployee;
import com.enesyalcin.entites.Department;
import com.enesyalcin.entites.Employee;
import com.enesyalcin.repository.EmployeeRepository;
import com.enesyalcin.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DTOEmployee> getAllEmployees() {
        List<DTOEmployee> dtoEmployees = new ArrayList<>();

        List<Employee> employees = employeeRepository.findAll();
        if (employees == null || employees.isEmpty()) {
            return null;
        }

        for (Employee employee : employees) {
            DTOEmployee dtoEmployee = new DTOEmployee();
            DTODepartment dtoDepartment = new DTODepartment();

            Department department = employee.getDepartment();
            BeanUtils.copyProperties(employee, dtoEmployee);
            BeanUtils.copyProperties(department, dtoDepartment);

            dtoEmployee.setDepartment(dtoDepartment);

            dtoEmployees.add(dtoEmployee);

        }
        return dtoEmployees;
    }

}

