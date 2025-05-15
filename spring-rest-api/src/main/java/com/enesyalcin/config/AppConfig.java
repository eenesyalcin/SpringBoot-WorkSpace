package com.enesyalcin.config;

import com.enesyalcin.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Enes", "YALÇIN"));
        employeeList.add(new Employee("2", "Sena Betül", "YAZICIOĞLU"));
        employeeList.add(new Employee("3", "Elif", "YALÇIN KAPLAN"));
        employeeList.add(new Employee("4", "Sıla", "YAZICIOĞLU"));
        employeeList.add(new Employee("5", "Feyza", "YAZICIOĞLU"));
        employeeList.add(new Employee("6", "Enes", "BAYRAM"));

        return employeeList;
    }

}
