package com.soso.studentmanager;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

 public interface StudentService{
      List<Student> findAllStudents();
      Student createStudent(Student student);
      Student findStudentByEmail(String email);
      boolean deleteStudent(String indexNumber);
      Student updateStudent(String email, Student student);
}



