package com.enesyalcin.services;

import com.enesyalcin.DTOs.DTOStudent;
import com.enesyalcin.DTOs.DTOStudentIU;
import com.enesyalcin.entites.Student;

import java.util.List;

public interface IStudentService {
    public DTOStudent addStudent(DTOStudentIU dtoStudentIU);
    public List<DTOStudent> getAllStudents();
    public DTOStudent getStudentById(Integer id);
    public String deleteStudent(Integer id);
    public DTOStudent updateStudent(DTOStudentIU student, Integer id);
}
