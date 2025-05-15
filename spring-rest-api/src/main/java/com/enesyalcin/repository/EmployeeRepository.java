package com.enesyalcin.repository;

import com.enesyalcin.model.Employee;
import com.enesyalcin.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    // Burada oluşturduğumuz Bean'den verileri aldık. Sanki bir veritabanından gelmiş gibi verileri aldık.
    @Autowired
    private  List<Employee> employeeList;

    public List<Employee> getAllEmployeeList() {
        // Burada ise aldığımız verileri metodumuzda geriye döndük. Yani service katmanına gönderdik.
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        Employee employee = null;
        for(Employee emp: employeeList) {
            if(id.equals(emp.getId())) {
                employee = emp;
                break;
            }
        }
        return employee;
    }



    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeListWithParams = new ArrayList<>();

        if(firstName == null && lastName == null) {
            return employeeList;
        }

        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {
                if(employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeListWithParams.add(employee);
                }
            }

            if(firstName != null && lastName == null) {
                if(employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeListWithParams.add(employee);
                }
            }

            if(firstName == null && lastName != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeListWithParams.add(employee);
                }
            }
        }

        return employeeListWithParams;
    }




    public Employee saveEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id) {
        Employee deleteEmployee = null;
        for(Employee employee: employeeList) {
            if (id.equals(employee.getId())) {
                deleteEmployee = employee;
                break;
            }
        }
        if(deleteEmployee == null) {
            return false;
        }
        employeeList.remove(deleteEmployee);
        return true;
    }



    private Employee findEmployeeById(String id) {
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                return employee;
            }
        }
        return null;
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest updateEmployee) {
        Employee findEmployee = findEmployeeById(id);
        if (findEmployee != null) {
            deleteEmployee(id);
            Employee updatedEmployee = new Employee();
            updatedEmployee.setId(id);
            updatedEmployee.setFirstName(updateEmployee.getFirstName());
            updatedEmployee.setLastName(updateEmployee.getLastName());
            employeeList.add(updatedEmployee);

            return updatedEmployee;
        }
        return null;
    }

}
