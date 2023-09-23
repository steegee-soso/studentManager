package com.soso.studentmanager;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Repository
public class InMemoryStudentDAO {

    private final List<Student> STUDENT =  new ArrayList<>();

    public List<Student> findAllStudents() {
        return STUDENT;
    }

    public Student createStudent(Student student) {
        STUDENT.add(student);
        return student;
    }

    public Student findStudentByEmail(String email) {
       return  STUDENT.stream().filter(student -> email.equals(student.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public boolean deleteStudent(String email) {

        var student  = this.findStudentByEmail(email);

        if(student==null){
            return false;
        }
        STUDENT.remove(student);
        return true;
    }

    public Student updateStudent(String email, Student student) {
        int studentIndex = IntStream.range(0, STUDENT.size())
                .filter(index->STUDENT.get(index).getEmail().equalsIgnoreCase(email.trim()))
                .findFirst().orElse(-1);

        if (studentIndex==-1){
            return null;
        }
        STUDENT.set(studentIndex,student);
        return student;
    }

}
