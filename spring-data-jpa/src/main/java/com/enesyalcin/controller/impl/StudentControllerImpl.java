package com.enesyalcin.controller.impl;

import com.enesyalcin.DTOs.DTOStudent;
import com.enesyalcin.DTOs.DTOStudentIU;
import com.enesyalcin.controller.IStudentController;
import com.enesyalcin.entites.Student;
import com.enesyalcin.services.IStudentService;
import com.enesyalcin.services.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    // DTO kullanılır.
    @PostMapping(path = "/add")
    @Override
    public DTOStudent addStudent(@RequestBody @Valid DTOStudentIU student) {
        return studentService.addStudent(student);
    }

    @GetMapping(path = "/getAll")
    @Override
    public List<DTOStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/getById/{id}")
    @Override
    public DTOStudent getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public String deleteStudent(@PathVariable(name = "id") Integer id){
        return studentService.deleteStudent(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DTOStudent updateStudent(@RequestBody @Valid DTOStudentIU student, @PathVariable(name = "id") Integer id) {
        return studentService.updateStudent(student, id);
    }


}
