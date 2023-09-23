package com.soso.studentmanager;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
//@Primary
public class DBStudentService  implements  StudentService{

    private final  StudentRepository studentRepository;
    public DBStudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public boolean deleteStudent(String email) {
        return  studentRepository.deleteByEmail(email);
    }

    @Override
    public Student updateStudent(String email, Student student) {
        return studentRepository.save(student);
    }
}
