package com.soso.studentmanager;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InMemoryStudentService implements StudentService  {

    private InMemoryStudentDAO inMemoryStudentDAO;

    public InMemoryStudentService(InMemoryStudentDAO inMemoryStudentDAO){
        this.inMemoryStudentDAO=inMemoryStudentDAO;
    }

    @Override
    public List<Student> findAllStudents() {
        return this.inMemoryStudentDAO.findAllStudents();
    }

    @Override
    public Student createStudent(Student student) {
        return this.inMemoryStudentDAO.createStudent(student);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return this.inMemoryStudentDAO.findStudentByEmail(email);
    }

    @Override
    public boolean deleteStudent(String email) {
        return this.inMemoryStudentDAO.deleteStudent(email);
    }

    @Override
    public Student updateStudent(String email, Student student) {
        return this.inMemoryStudentDAO.updateStudent(email,student);
    }
}
