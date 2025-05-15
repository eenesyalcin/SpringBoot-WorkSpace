package com.enesyalcin.controller;

import com.enesyalcin.model.Employee;
import com.enesyalcin.model.UpdateEmployeeRequest;
import com.enesyalcin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Buradaki controllerlarda istek atılacak tüm metotların path kısmında yer alacak köünü tanımladık.
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

    // Burada controller kısmını service kısmına bağlayabilmek için @Autowired kullandık.
    @Autowired
    private EmployeeService employeeService;

    // Burada çalışanların hepsini getirmesi için bir metot oluşturduk ve @GetMapping ile istek atılacak path verdik.
    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList(){

        // Burada servise tanımlanan metoda git komutu verdik.
        // h employeeService.getAllEmployeeList();

        // Burada client tarafına verileri döndük.
        return employeeService.getAllEmployeeList();
    }

    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName,
                                                @RequestParam(name = "lastName", required = false) String lastName){
        System.out.println(firstName + " " + lastName);
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }


    @PostMapping(path = "/save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee){
        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping(path = "/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") String id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/update-employee/{id}")
    public Employee updateEmployee(@PathVariable(name = "id") String id, @RequestBody UpdateEmployeeRequest updateEmployee){
        return employeeService.updateEmployee(id, updateEmployee);
    }

}
