package com.enesyalcin.services.impl;

import com.enesyalcin.DTOs.DTOCourse;
import com.enesyalcin.DTOs.DTOStudent;
import com.enesyalcin.DTOs.DTOStudentIU;
import com.enesyalcin.entites.Course;
import com.enesyalcin.entites.Student;
import com.enesyalcin.repository.StudentRepository;
import com.enesyalcin.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public DTOStudent addStudent(DTOStudentIU dtoStudentIU) {
        DTOStudent responseStudent = new DTOStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);

        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, responseStudent);
        return responseStudent;
    }


    @Override
    public List<DTOStudent> getAllStudents() {
        List<DTOStudent> responseStudents = new ArrayList<>();
        List<Student> students = studentRepository.findAllStudents();
        for (Student student : students) {
            DTOStudent dtoStudent = new DTOStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            responseStudents.add(dtoStudent);
        }
        return responseStudents;
    }


    @Override
    public DTOStudent getStudentById(Integer id) {
        DTOStudent dtoStudent = new DTOStudent();
        List<DTOCourse> dtoCourses = new ArrayList<>();

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            return null;
        }

        Student dbStudent = optionalStudent.get();
        BeanUtils.copyProperties(dbStudent, dtoStudent);

        if (dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
            for (Course course : dbStudent.getCourses()) {
                DTOCourse DTOCourse = new DTOCourse();
                BeanUtils.copyProperties(course, DTOCourse);
                dtoCourses.add(DTOCourse);
            }
        }

        dtoStudent.setCourses(dtoCourses);
        return dtoStudent;
    }


    public String deleteStudent(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return "Öğrenci başarıyla silindi.";
        }
        return "Silmek için bir öğrenci bulunamadı!";
    }


    public DTOStudent updateStudent(DTOStudentIU dtoStudentIU, Integer id){
        DTOStudent responseStudent = new DTOStudent();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setId(id);
            student.setFirstName(dtoStudentIU.getFirstName());
            student.setLastName(dtoStudentIU.getLastName());
            student.setBirthOfDate(dtoStudentIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(student);
            BeanUtils.copyProperties(updatedStudent, responseStudent);
            return responseStudent;
        }
        return null;
    }

}
