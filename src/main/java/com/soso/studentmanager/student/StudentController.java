package com.soso.studentmanager.student;


import com.soso.studentmanager.DBStudentService;
import com.soso.studentmanager.Student;
import com.soso.studentmanager.InMemoryStudentService;
import com.soso.studentmanager.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private StudentService studentService;
    public StudentController(@Qualifier("DBStudentService") StudentService studentService){
        this.studentService= studentService;
    }
    @GetMapping
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/{email}")
    public Student findStudentByEmail(@PathVariable String email){
        return studentService.findStudentByEmail(email);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        String email = student.getEmail().toString();
        return studentService.updateStudent(email, student);
    }

    @DeleteMapping("/{email}")
    public void deleteStudent(@PathVariable String email){
      boolean isDeleted  = studentService.deleteStudent(email);
    }


}
