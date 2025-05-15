package com.enesyalcin.repository;

import com.enesyalcin.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //Buralarda kendimize özel metotlar da yazacağız.

    // HQL: Sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır.
    // SQL: Tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılır.

    // HQL
    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudents();

    // HQL
    @Query(value = "from Student s WHERE s.id = :studentId")
    Optional<Student> findStudentById(Integer studentId);

}
