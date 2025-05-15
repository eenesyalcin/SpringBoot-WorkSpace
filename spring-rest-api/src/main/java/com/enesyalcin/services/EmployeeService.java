package com.enesyalcin.services;

import com.enesyalcin.model.Employee;
import com.enesyalcin.model.UpdateEmployeeRequest;
import com.enesyalcin.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    // Burada @Autowired anatasyonu ile repositoryi servise enjekte etttik. Eğer bunu yapmasaydık null pointer hatası yerdik.
    @Autowired
    private EmployeeRepository employeeRepository;

    // Burada ise çalışanları listelemek için yine bir metot yazdık.
    public List<Employee> getAllEmployeeList() {

        // Burada repositoryde tanımlanan metoda git komutu verdik.
        // employeeRepository.getAllEmployeeList();

        // Burada Controller katmanına verileri döndük.
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    public  boolean deleteEmployee(String id) {
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest updatedEmployee) {
        return employeeRepository.updateEmployee(id, updatedEmployee);
    }

}
